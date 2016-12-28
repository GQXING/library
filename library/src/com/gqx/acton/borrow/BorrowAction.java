package com.gqx.acton.borrow;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gqx.dao.BorrowDao;
import com.gqx.dao.impl.BorrowDaoImpl;
import com.gqx.entity.Book;
import com.gqx.entity.CLRClass;
import com.gqx.entity.Reader;
import com.gqx.entity.User;
import com.gqx.service.borrow.BorrowService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BorrowAction extends ActionSupport{
	private int readID;
	public void setReadID(int readID) {
		this.readID = readID;
	}
	public int getReadID() {
		return readID;
	}	
	BorrowService service=new BorrowService();
	private BorrowDao borrowDao=new BorrowDaoImpl();
	//读者查询
	public String checkreader(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		Reader reader=borrowDao.getReader(readID);
		if (reader!=null) {
			reqestMap.put("readerInfo", reader);
			reqestMap.put("rd_bkQty", service.getQtyStatus(readID));
			reqestMap.put("borrow_money", service.getallMoney(readID));
		}
		reqestMap.put("status", 1);
		return "oks";
	}
	//图书状态查询
	private int bkID;
	public void setBkID(int bkID) {
		this.bkID = bkID;
	}
	public int getBkID() {
		return bkID;
	}
	public String checkbook(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		Book book=service.getBookById(bkID);
		if (book!=null) {
			reqestMap.put("bookInfo", book);
		}
		reqestMap.put("status", 2);
		return "oks";
	}

	//续借/归还操作要查询到该数的所有使用者
	public String findByBk(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		List<CLRClass> list=service.getReaderBybkId(bkID);
		
		reqestMap.put("list", list);
		reqestMap.put("status", 3);
		return "oks";
	}


	private String OperatorLend;
	public void setOperatorLend(String operatorLend) {
		OperatorLend = operatorLend;
	}
	public String getOperatorLend() {
		return OperatorLend;
	}
	public String lendBook(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		service.borrowLend(readID, bkID, OperatorLend);
		reqestMap.put("lendBookResult", 1);
		reqestMap.put("lenderName", service.getReader(readID).getRdName());
		return "oks";
	}
	private int rdID;
	
	public void setRdID(int rdID) {
		this.rdID = rdID;
	}
	public int getRdID() {
		return rdID;
	}
	
	public String continueLend(){
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		reqestMap.put("continueResult", service.lendAgain(rdID, bkID));
		return "oks";
	}
	public String returnBook(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("borrowAdmin");
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		String OperatorRet=user.getName();
		service.borrowRet(rdID, bkID, OperatorRet);
		reqestMap.put("returnBookResult", "还书成功");
		return "oks";
	}
	
	//缴费
	public String punishMoney(){
		service.punishMoney(rdID);
		Map<String, Object> reqestMap=ActionContext.getContext().getContextMap();
		reqestMap.put("punishMoney", "还款成功");
		return "oks";
	}
}
