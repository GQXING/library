package com.gqx.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.gqx.dao.BorrowDao;
import com.gqx.entity.Book;
import com.gqx.entity.Borrow;
import com.gqx.entity.CLRClass;
import com.gqx.entity.Reader;
import com.gqx.entity.ReaderType;
import com.gqx.util.JDBCUtil;
import com.gqx.util.JUtil;

public class BorrowDaoImpl implements BorrowDao {

	@Override
	public Reader getReader(int rdID) {
		// TODO Auto-generated method stub
		String sql="select * from TB_Reader where rdID=?";
		try {
			return JDBCUtil.getQuerrRunner().query(sql, new BeanHandler<Reader>(Reader.class),rdID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBook(int bkID) {
		String sql="select * from TB_Book where bkID=?";
		try {
			return JDBCUtil.getQuerrRunner().query(sql, new BeanHandler<Book>(Book.class),bkID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void borrowLend(int rdID,int bkID,String operatorLend) {
		// TODO Auto-generated method stub
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		String sql="insert into TB_Borrow (rdID,bkID,IdDateRetPlan,OperatorLend) values (?,?,?,?)";
		Reader reader=this.getReader(rdID);
		ReaderType readerType=this.getReaderType(reader.getRdType());
		java.util.Date date=new Date(System.currentTimeMillis());
		Calendar   calendar=new GregorianCalendar(); 
		calendar.setTime(date);
		calendar.add(calendar.DATE, readerType.getCanLendDay());//把日期往后增加n天.整数往后推,负数往前移动 
		date=calendar.getTime();
	    Date date2=new Date(date.getTime());
		try {
			Map<String,Object> insertRs = runner.insert(sql,new MapHandler(),
					rdID,bkID,date2,operatorLend);
			this.modifyLendNumBook(rdID, 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrowRet(int rdID,int bkID,String OperatorRet){
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Borrow set IdDateRetAct=?,IdOverDay=?,IdOverMoney=?,IsHasReturn=?,OperatorRet=? where rdID=? and bkID=?";
		//得到相隔的天数
		Date date=new Date(System.currentTimeMillis());
		Borrow borrow=this.getBorrow(rdID, bkID);
		Date date2=borrow.getIdDateRetPlan();
		int s=(int)((date.getTime() - date2.getTime())/86400000);
		Float  money=null;
		if (s>0) {
			money=(float) (s*0.05);
		}else {
			money=(float) 0;
			s=0;
		}
		try {
			statement=connection.prepareStatement(sql);
			statement.setDate(1, date);
			statement.setInt(2, s);
			statement.setFloat(3, money);
			statement.setInt(4, 1);
			statement.setString(5, OperatorRet);
			statement.setInt(6, rdID);
			statement.setInt(7, bkID);
			statement.executeUpdate();
			this.modifyLendNumBook(rdID, -1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public Integer lendAgain(int rdID, int bkID) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		Borrow borrow=this.getBorrow(rdID, bkID);
		Reader reader=this.getReader(rdID);
		ReaderType readerType=this.getReaderType(reader.getRdType());
		java.util.Date date=new Date(System.currentTimeMillis());
		Calendar   calendar=new GregorianCalendar(); 
		calendar.setTime(date);
		calendar.add(calendar.DATE, readerType.getCanLendDay());//把日期往后增加n天.整数往后推,负数往前移动 
		date=calendar.getTime();
	    Date date2=new Date(date.getTime());
		String sql="update TB_Borrow set IdContinueTimes=IdContinueTimes+1,IdDateRetPlan=DATEADD(DAY,30,IdDateRetPlan) where rdID=? and bkID=?";
		if (borrow.getIdContinueTimes()==readerType.getCanContinueTimes()) {
			//不能续借
			return borrow.getIdContinueTimes();
		}
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, rdID);
			statement.setInt(2, bkID);
			statement.executeUpdate();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 8;
	}

	@Override
	public Borrow getBorrow(int rdID, int bkID) {
		// TODO Auto-generated method stub
		String sql="select * from TB_Borrow where rdID=? and bkID=?";
		try {
			return JDBCUtil.getQuerrRunner().query(sql, new BeanHandler<Borrow>(Borrow.class),rdID,bkID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




	//获取Reader_Type表中读者类型和续借的天数
	public ReaderType getReaderType(int rdType){
		String sql="select * from TB_ReaderType where rdType=?";
		try {
			return JDBCUtil.getQuerrRunner().query(sql, new BeanHandler<ReaderType>(ReaderType.class),rdType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//修改此人的借书数量
	public void modifyLendNumBook(int rdID,int num){
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Reader set rdBorrowQty=rdBorrowQty+? where rdID=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, num);
			statement.setInt(2, rdID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取该某读者的借书数量
	public int getRdBorrowQty(int rdID){
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		ResultSet result=null;
		String sql="select rdBorrowQty from TB_Reader where rdID=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, rdID);
			result=statement.executeQuery();
			while(result.next()){
				return result.getInt("rdBorrowQty");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 100;
	}

	@Override
	public float getMoney(int rdID, int bkID) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		ResultSet result=null;
		String sql="select IdOverMoney from TB_Borrow where rdID=? and bkID=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, rdID);
			statement.setInt(2, bkID);
			result=statement.executeQuery();
			while(result.next()){
				return result.getFloat("IdOverMoney");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public float getallMoney(int rdID) {
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		ResultSet result=null;
		String sql="select IdOverMoney from TB_Borrow where rdID=?";
		float sum=0;
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, rdID);
			
			result=statement.executeQuery();
			while(result.next()){
				sum+= result.getFloat("IdOverMoney");
			}
			return sum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}

	@Override
	public Book getBookById(int bkID) {
		// TODO Auto-generated method stub
		String sql="select * from TB_Book where bkID=?";
		try {
			return JDBCUtil.getQuerrRunner().query(sql, new BeanHandler<Book>(Book.class),bkID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CLRClass> getReaderBybkId(int bkID) {
		String sql="select rdName,bkName,IdContinueTimes,TB_Reader.rdID,TB_Book.bkID,CanContinueTimes,IsHasReturn,IdDateRetPlan from TB_Reader,TB_Book,TB_Borrow,TB_ReaderType "+
				"where TB_Reader.rdID=TB_Borrow.rdID and TB_Borrow.bkID=TB_Book.bkID and TB_Book.bkID=? and TB_Reader.rdType=TB_ReaderType.rdType and IsHasReturn=0";
		try {
			return JDBCUtil.getQuerrRunner().query(sql,new BeanListHandler<CLRClass>(CLRClass.class),bkID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void punishMoney(int rdID) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Borrow set IdPunishMoney=0,IdOverMoney=0 where rdID=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, rdID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
