package com.gqx.acton.reader;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gqx.entity.Book;
import com.gqx.entity.Reader;
import com.gqx.service.reader.ReaderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReaderAction extends ActionSupport{
	ReaderService service=new ReaderService();
	public String borrowBook(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Reader reader=(Reader) session.getAttribute("reader");
		int rdID=reader.getRdID(); 
		List<Book> list=service.getBookByrdID(rdID);
		reqestMap.put("bookList", list);
		return "oks";
	}
	private String password;
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String modifyPwd(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		Reader reader=(Reader) session.getAttribute("reader");
		reader.setRdPwd(password);
		request.setAttribute("reader", reader);
		int rdID=reader.getRdID(); 
		service.modifyPwd(rdID, password);
		reqestMap.put("modifyResult", "ÐÞ¸Ä³É¹¦£¡");
		return "oks";
	}
	
}
