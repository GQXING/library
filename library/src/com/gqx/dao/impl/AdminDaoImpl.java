package com.gqx.dao.impl;

import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.gqx.dao.AdminDao;
import com.gqx.entity.Reader;
import com.gqx.util.JDBCUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public void setAdmin(String name,String password, int readerType) {
		// TODO Auto-generated method stub
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		String sql="insert into administer (type,name,password) values(?,?,?)";
		try {
			Map<String,Object> insertRs=runner.insert(sql,new MapHandler(),readerType,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
