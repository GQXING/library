package com.gqx.service.book;

import com.gqx.dao.impl.BookDaoImpl;
import com.gqx.entity.Book;

public class BookService {
	BookDaoImpl bookdao=new BookDaoImpl();
	//����ͼ��
	public Book checkBook(String bkName,String isbnBook){
		return bookdao.checkBook(bkName, isbnBook);
	}
	//�޸�ͼ��
	public void modifyBook(Book book){
		bookdao.modifyBook(book);
	}
	//����ͼ��
	public void insertBook(Book book){
		bookdao.insertBook(book);
	}
	//����ͼ��
	public void deleteBook(String bkName,String isbnBook){
		bookdao.deleteBook(bkName, isbnBook);
	}
	//����ͼ��id��ȡͼ��
	public Book getBkById(int id){
		return bookdao.getBkById(id);
	}
	

}
