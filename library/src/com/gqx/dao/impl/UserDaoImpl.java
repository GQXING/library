package com.gqx.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.gqx.dao.UserDao;
import com.gqx.entity.Reader;
import com.gqx.entity.User;
import com.gqx.util.JDBCUtil;
import com.gqx.util.JUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int Login(User user) {
		String sql="select * from administer where name=? and password=? and type=?";
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		try {
			User user2=runner.query(sql, new BeanHandler<User>(User.class),user.getName(),user.getPassword(),user.getUserType());
		
			if (user2!=null) {
				return user.getUserType();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Reader check(String name, String dept, String userType) {
		// TODO Auto-generated method stub
		String sql="select * from TB_Reader where rdName=? and rdDept=? and rdType=?";
		try {
			return JDBCUtil.getQuerrRunner().query(sql, new BeanHandler<Reader>(Reader.class),name,dept,userType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String check2(String name, String dept, String userType) {
		// TODO Auto-generated method stub
		String sql="select * from TB_Reader where rdName=? and rdDept=? and rdType=?";
		Connection connection=JUtil.getConnection();
		PreparedStatement statement=null;
		Date date=null;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setString(2, dept);
			statement.setString(3, userType);
			ResultSet result=statement.executeQuery();
			while(result.next()){
				date=result.getDate("rdDateReg");
				return date.toString();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	@Override
	public void insertReader(Reader reader) {
		// TODO Auto-generated method stub
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		String sql="insert into TB_Reader (rdName,rdSex,rdType,rdDept,rdPhone,rdEmail,rdPhoto,rdStatus,rdPwd,rdAdminRoles) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			Map<String,Object> insertRs = runner.insert(sql,new MapHandler(),
					reader.getRdName(),reader.getRdSex(),reader.getRdType(),reader.getRdDept(),reader.getRdphone(),reader.getRdEmail(), 
					reader.getRdPhoto(),reader.getRdStatus(),reader.getRdPwd(),reader.getRdAdminRoles());
//			System.out.println("MapHandler:" + insertRs.get("GENERATED_KEYS"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean Update(int rdId, Reader reader) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Reader set rdName=?,rdSex=?,rdType=?,rdDept=?,rdPhone=?,rdPwd=? where rdID=?";
		//,rdSex=?,rdType=?,rdDept=?,rdPhone=?,rdStatus=?,rdPwd=? 
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, reader.getRdName());
			statement.setString(2, reader.getRdSex());
			statement.setInt(3, reader.getRdType());
			statement.setString(4, reader.getRdDept());
			statement.setString(5, reader.getRdphone());
			statement.setString(6, reader.getRdPwd());
			statement.setInt(7, rdId);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Reader reader(int rdID) {
		// TODO Auto-generated method stub
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
	public void lost(int rdID) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Reader set rdStatus=0 where rdID=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, rdID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void logout(int rdID) {
		// TODO Auto-generated method stub
		QueryRunner runner=JDBCUtil.getQuerrRunner();
		String sql="delete from TB_Reader where rdID="+rdID;
		try {
			runner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void reback(int rdID) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Reader set rdStatus=1 where rdID=?";
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, rdID);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Reader readerLogin(Reader reader) {
		// TODO Auto-generated method stub
		String sql="select * from TB_Reader where rdName=? and rdPwd=?";
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		try {
			Reader reader2=runner.query(sql, new BeanHandler<Reader>(Reader.class),reader.getRdName(),reader.getRdPwd());
			
			if (reader2!=null) {
				return reader2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
