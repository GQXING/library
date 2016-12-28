package com.gqx.acton.admin;

import java.util.Map;

import com.gqx.entity.Reader;
import com.gqx.entity.User;
import com.gqx.service.Admin.AdminService;
import com.gqx.service.borrow.BorrowService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private int readerID;
	public void setReaderID(int readerID) {
		this.readerID = readerID;
	}
	public int getReaderID() {
		return readerID;
	}
	BorrowService borrowDao=new BorrowService();
	AdminService adminService=new AdminService();
	private User user;
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public String setAdmin(){
		adminService.setAdmin(user.getName(), user.getPassword(), user.getUserType());
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		reqestMap.put("status", 2);
		reqestMap.put("statusName", user.getName());
		return "oks";
	}
	public String checkreader(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		Reader reader=borrowDao.getReader(readerID);
		System.out.println(reader);
		if (reader!=null) {
			reqestMap.put("readerInfo", reader);
		}
		reqestMap.put("status", 1);
		return "oks";
	}
}
