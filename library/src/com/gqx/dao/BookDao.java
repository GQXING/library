package com.gqx.dao;

import java.util.List;

import com.gqx.entity.Book;

public interface BookDao {
	//根据信息获取ID
	public int FindBkId(String bkName,String isbnBook);
	//查找图书
	public Book checkBook(String bkName,String isbnBook);
	//修改图书
	public void modifyBook(Book book);
	//插入图书
	public void insertBook(Book book);
	//销毁图书
	public void deleteBook(String bkName,String isbnBook);
	//根据图书id获取图书
	public Book getBkById(int id); 
	//获取所有图书
	public List<Book> getBooks();
}
