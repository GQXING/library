package com.gqx.acton.login;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gqx.entity.Reader;
import com.gqx.entity.User;
import com.gqx.service.login.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private User user=new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	UserService userService=new UserService();
	public String login(){
		if (user.getUserType()==1) {
			Reader reader2=new Reader();
			reader2.setRdName(user.getName());
			reader2.setRdPwd(user.getPassword());
			Reader reader=userService.readerLogin(reader2);
			System.out.println(reader);
			if (reader!=null) {
				HttpServletRequest request=ServletActionContext.getRequest();
				HttpSession session=request.getSession();
				session.setAttribute("reader", reader);
				return "loginSuccess1";
			}
			return "loginFail";	
		}
		
		if (userService.login(user)==2) {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			return "loginSuccess2";
		}else if (userService.login(user)==3) {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("BookAdmin", user);
			return "loginSuccess3";
		}else if (userService.login(user)==4) {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("borrowAdmin", user);
			return "loginSuccess4";
		}else if (userService.login(user)==5) {
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("admin", user);
			return "loginSuccess5";
		}
		else{
			return "loginFail";
		}

	}

	public String exit(){
		//×¢Ïú
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if (session.getAttribute("user")!=null) {
			session.removeAttribute("user");
		}
		if (session.getAttribute("BookAdmin")!=null) {
			session.removeAttribute("BookAdmin");
		}
		if (session.getAttribute("borrowAdmin")!=null) {
			session.removeAttribute("borrowAdmin");
		}
		if (session.getAttribute("admin")!=null) {
			session.removeAttribute("admin");
		}
		if (session.getAttribute("reader")!=null) {
			session.removeAttribute("reader");
		}
		return "loginSuccess";
	}

}
