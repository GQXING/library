package com.gqx.acton.lendIDAdminister;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gqx.entity.Reader;
import com.gqx.service.lendIDAdminister.LendIDAdministerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LendIDAdminister extends ActionSupport{
	LendIDAdministerService service=new LendIDAdministerService();
	//数据封装
	private String userName;
	private String userType;
	private String dept;
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserType() {
		return userType;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	public String checkName() throws IOException{
		Reader reader=service.checkReader(userName, dept, userType);
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		if (reader!=null) {
			Date date=reader.getRdDateReg();
			SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日");
			String str=df.format(date);
			reqestMap.put("reader", reader);
			reqestMap.put("date", str);
		}
		reqestMap.put("status", 1);
		return "oks";
	}
	/***处理相应的按钮****/
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	//注销该账号
	public String logout(){
		service.logout(id);
		return "oks";
	}
	//挂失状态的账号
	public String lost(){
		service.lost(id);
		return "oks";
	}
	//恢复挂失状态的账号
	public String reback(){
		service.reback(id);
		return "oks";
	}


	//查找要修改人物的信息
	public String find(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		Reader reader=service.reader(id);
		if (reader!=null) {
			Date date=reader.getRdDateReg();
			SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日");
			String str=df.format(date);
			reqestMap.put("readerm", reader);
			reqestMap.put("date", str);
		}
		reqestMap.put("modify", 1);
		return "oks";
	}
	
}
