package com.gqx.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DATA_CONVERSION;

import com.gqx.dao.impl.BookDaoImpl;
import com.gqx.entity.Book;
import com.gqx.service.book.BookService;


public class BookTest {
	 Book book=null;
	 BookDaoImpl bookDao=null;
	//��ʼ����������ʵ��
	@Before
	public void init(){
		book=new Book();
		bookDao=new BookDaoImpl();
	}
	@Test
	public void testInsert() {
		/*
		 * bkCode,bkName,bkAuthor,bkPress,bkDataPress,bkISBN,
		 * bkLanguage,bkPage,bkPrice,bkBrief,bkStatus
		 */
		book.setBkCode("1002");
		book.setBkName("���Ͼ���");
		book.setBkAuthor("����");
		book.setBkPress("����������");
		Date date=Date.valueOf("2014-12-25");
		book.setBkDatePress(date);
		book.setBkISBN("1672-5913 ");
		book.setBkLanguage(1);
		book.setBkPages(300);
		book.setBkBrief("�Խ�ѧ���ݿ�Ϊ��");
		book.setBkPrice(24);
		book.setBkStatus("�ڹ�");
		bookDao.insertBook(book);
	}
	
	@Test
	public void testModify() {
		/*
		 * bkCode,bkName,bkAuthor,bkPress,bkDataPress,bkISBN,
		 * bkLanguage,bkPage,bkPrice,bkBrief,bkStatus
		 */
		book.setBkID(1);
		book.setBkName("���ݿ�");
		book.setBkAuthor("���");
		book.setBkPress("����������");
		Date date=Date.valueOf("2012-12-25");
		book.setBkDatePress(date);
		book.setBkISBN("1672-5913 ");
		book.setBkLanguage(1);
		book.setBkPages(300);
		book.setBkBrief("�Խ�ѧ���ݿ�Ϊ��");
		book.setBkPrice(24);
		book.setBkStatus("�ڹ�");
		BookService service=new BookService();
		service.modifyBook(book);
//		bookDao.modifyBook(book);
	}
	
	@Test
	public void testCheck() {
		Book book=bookDao.checkBook("���ݿ�", "1672-5913");
		System.out.println(book);
	}
	@Test
	public void testDelete() {
		bookDao.deleteBook("����ϵͳ", "1672-5913");
	}
	@Test
	public void testfind() {
		System.out.println(bookDao.getBkById(1));
	}
	@Test
	public void bookfind() {
		List<Book> list=bookDao.getBooks();
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
}
