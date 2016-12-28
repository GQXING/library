package com.gqx.service.book;

import com.gqx.dao.impl.BookDaoImpl;
import com.gqx.entity.Book;

public class BookService {
	BookDaoImpl bookdao=new BookDaoImpl();
	//查找图书
	public Book checkBook(String bkName,String isbnBook){
		return bookdao.checkBook(bkName, isbnBook);
	}
	//修改图书
	public void modifyBook(Book book){
		bookdao.modifyBook(book);
	}
	//插入图书
	public void insertBook(Book book){
		bookdao.insertBook(book);
	}
	//销毁图书
	public void deleteBook(String bkName,String isbnBook){
		bookdao.deleteBook(bkName, isbnBook);
	}
	//根据图书id获取图书
	public Book getBkById(int id){
		return bookdao.getBkById(id);
	}
	

}
