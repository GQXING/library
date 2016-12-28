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
	 static String user=null;			//���ݿ����Ա��
	 static String pass=null;		//����
	 static String driver=null;		//����
	
	/*
	 * ��̬�����ֻ����һ��
	 */
	static{
		//��ȡdb.propties
		try {
			Properties proper =new Properties();
			/**
			 *  . ����java�������е�Ŀ¼
			 *  ��java��Ŀ�£�. java���������Ŀ¼����Ŀ�ĸ�Ŀ¼��ʼ
			 *  ��web��Ŀ�£�  . java����Ķ�����Ŀ¼��tomcat/binĿ¼��ʼ
			 *  ���Բ���ʹ�õ�.
			 */
			//FileInputStream in =new FileInputStream("./src/db.properties");
			java.io.InputStream in = JUtil.class.getResourceAsStream("/db.properties");
			//������Ϣ
			proper.load(in);
			url=proper.getProperty("url");
			user=proper.getProperty("user");
			pass=proper.getProperty("pass");
			driver=proper.getProperty("driver");
			//��ȡ��Ϣ
				Class.forName(driver);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������ע��ʧ��");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ��ȡJDBC���Ӷ���ķ���
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
	 * �رղ���
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
	 * ���Ƿ���������
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
