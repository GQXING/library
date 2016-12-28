package com.gqx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.omg.CORBA.portable.InputStream;

public class JUtil {
	
	static String url=null;
	 static String user=null;			//数据库管理员名
	 static String pass=null;		//密码
	 static String driver=null;		//密码
	
	/*
	 * 静态代码块只加载一次
	 */
	static{
		//读取db.propties
		try {
			Properties proper =new Properties();
			/**
			 *  . 代表java命令运行的目录
			 *  在java项目下，. java命令的运行目录从项目的根目录开始
			 *  在web项目下，  . java命令的而运行目录从tomcat/bin目录开始
			 *  所以不能使用点.
			 */
			//FileInputStream in =new FileInputStream("./src/db.properties");
			java.io.InputStream in = JUtil.class.getResourceAsStream("/db.properties");
			//加载信息
			proper.load(in);
			url=proper.getProperty("url");
			user=proper.getProperty("user");
			pass=proper.getProperty("pass");
			driver=proper.getProperty("driver");
			//读取信息
				Class.forName(driver);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驱动程序注册失败");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 获取JDBC连接对象的方法
	 */
	public static Connection getConnection(){
		try {
			Connection connection=DriverManager.getConnection(url,user,pass);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/*
	 * 关闭操作
	 */
	
	public static void close(Connection con,Statement stmt){
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	
	/**
	 * 这是方法的重载
	 * @param con
	 * @param stmt
	 * @param resultSet
	 */
public static void close(Connection con,Statement stmt,ResultSet resultSet){
	if (resultSet!=null) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
