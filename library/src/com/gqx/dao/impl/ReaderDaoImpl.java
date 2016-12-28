package com.gqx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.gqx.dao.ReadDao;
import com.gqx.entity.Book;
import com.gqx.entity.CLRClass;
import com.gqx.util.JDBCUtil;
import com.gqx.util.JUtil;

public class ReaderDaoImpl implements ReadDao {

	@Override
	public List<Book> getBookByrdID(int rdID) {
		// TODO Auto-generated method stub
		String sql="select bkName,bkAuthor,bkPress from TB_Reader,TB_Book,TB_Borrow where TB_Reader.rdID=TB_Borrow.rdID and TB_Borrow.bkID=TB_Book.bkID and TB_Reader.rdID=? and IsHasReturn=1";
		try {
			return JDBCUtil.getQuerrRunner().query(sql,new BeanListHandler<Book>(Book.class),rdID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modifyPwd(int rdID,String pwd) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Reader set rdPwd=? where rdID=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, pwd);
			statement.setInt(2, rdID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
