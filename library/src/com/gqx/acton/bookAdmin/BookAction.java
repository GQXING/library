package com.gqx.acton.bookAdmin;

import java.sql.Date;
import java.util.Map;

import javax.xml.crypto.Data;

import com.gqx.entity.Book;
import com.gqx.service.book.BookService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	BookService service=new BookService();
	private String bookName;
	private String bookNo;
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookNo() {
		return bookNo;
	}
	public String checkBook(){
		Book book=service.checkBook(bookName, bookNo);
		Map<String, Object> requestMap=ActionContext.getContext().getContextMap();
		if (book!=null) {
			requestMap.put("book", book);
		}
		requestMap.put("bookStatus", 1);
		return "success";
	}
	public String delete(){
		Map<String, Object> requestMap=ActionContext.getContext().getContextMap();
		service.deleteBook(bookName, bookNo);
		requestMap.put("bookStatus", 5);
		return "success";
	}

	private int id;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String findmodify(){
		Map<String, Object> requestMap=ActionContext.getContext().getContextMap();
		Book bookm=service.getBkById(id);
		if (bookm!=null) {
			requestMap.put("bookm", bookm);
		}
		requestMap.put("bookStatus", 2);
		return "success";
	}

	private Book book;
	public void setBook(Book book) {
		this.book = book;
	}
	public Book getBook() {
		return book;
	}
	public String modify(){
		Map<String, Object> requestMap=ActionContext.getContext().getContextMap();
		String str=book.getBkDatePress().toString();
		System.out.println(str);
		book.setBkDatePress(Date.valueOf(str));
		service.modifyBook(book);
		requestMap.put("bookStatus", 3);
		return "success";
	}
	public String insertBook(){
		Map<String, Object> requestMap=ActionContext.getContext().getContextMap();
		String str=book.getBkDatePress().toString();
		System.out.println(str);
		book.setBkDatePress(Date.valueOf(str));
		service.insertBook(book);
		requestMap.put("bookStatus", 4);
		return "success";
	}

}
