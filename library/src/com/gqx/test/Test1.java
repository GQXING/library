package com.gqx.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.apache.struts2.ServletActionContext;
import org.junit.Before;
import org.junit.Test;

import com.gqx.dao.impl.AdminDaoImpl;
import com.gqx.dao.impl.UserDaoImpl;
import com.gqx.entity.Reader;
import com.gqx.entity.User;

public class Test1 {
	 User user=null;
	 UserDaoImpl userDaoImpl=null;
	//初始化这个对象的实例
	@Before
	public void init(){
		user=new User();
		userDaoImpl=new UserDaoImpl();
	}
	
	@Test
	public void testLogin() {
		user.setName("李四");
		user.setPassword("11");
		user.setUserType(3);
		System.out.println(userDaoImpl.Login(user));
	}
	
	@Test
	public void testCheck() {
		Reader reader=userDaoImpl.check("李四", "计算机科学学院", "2");
		System.out.println(reader.getRdBorrowQty());
	}
	
	@Test
	public void testInsertRd() throws ParseException {
		Reader reader=new Reader();
		reader.setRdName("admin");
		reader.setRdSex("男");
		reader.setRdType(2);
		reader.setRdDept("文学院");
		reader.setRdphone("1233");
		reader.setRdPhoto("F:/33");
		reader.setRdStatus("1");
		reader.setRdPwd("123");
		reader.setRdAdminRoles(0);
		userDaoImpl.insertReader(reader);
	}
	
	@Test
	public void Update() {
		Reader reader=new Reader();
		reader.setRdName("某1");
		reader.setRdSex("男");
		reader.setRdType(2);
		reader.setRdDept("文学院");
		reader.setRdphone("1233");
		reader.setRdPhoto("F:/33");
		reader.setRdStatus("1");
		reader.setRdBorrowQty(30);
		reader.setRdEmail("123@qq.com");
		reader.setRdPwd("123");
		reader.setRdAdminRoles(0);
		userDaoImpl.Update(1003, reader);
	}
	@Test
	public void reader() {
		Reader reader=userDaoImpl.reader(12);
		System.out.println(reader.toString());
	}
	@Test
	public void reade1() {
		 HttpServletRequest request=ServletActionContext.getRequest();
		
		System.out.println( request.getContextPath());
	}
	
	@Test
	public void lost() {
		 userDaoImpl.lost(1);
	}
	@Test
	public void reback() {
		 userDaoImpl.reback(1);;
	}
	@Test
	public void logout() {
		 userDaoImpl.logout(1002);
	}
	
	@Test
	public void testDate() {
//		 java.util.Date date=new Date(System.currentTimeMillis());
//		 Calendar   calendar   =   new   GregorianCalendar(); 
//	     calendar.setTime(date); 
//	     calendar.add(calendar.DATE, 30);//把日期往后增加一天.整数往后推,负数往前移动 
//		 Date date=new Date(System.currentTimeMillis());
//		 date.setMonth(date.getMonth()+1);
//	     date=calendar.getTime();
//	     Date date2=new Date(date.getTime());
//		Date date=new Date(System.currentTimeMillis());
//		Date date1=Date.valueOf("2016-12-13");
//		int s=(int)((date.getTime() - date1.getTime())/86400000);
//		 System.out.println(s);
//		Float s=(float) (0);
//		System.out.println(s);
		java.util.Date date=new Date(System.currentTimeMillis());
		Date date1=Date.valueOf(date.toString());
		System.out.println(date1);
	}
	
	@Test
	public void readerLogin(){
		Reader reader2=new Reader();
		reader2.setRdName("郭庆兴");
		reader2.setRdPwd("111");
		Reader reader=userDaoImpl.readerLogin(reader2);
		System.out.println(reader);
	}
	
	@Test
	public void readerLogin11(){
		AdminDaoImpl adminDaoImpl=new AdminDaoImpl();
		adminDaoImpl.setAdmin("qq", "12", 2);
	}
	
}
