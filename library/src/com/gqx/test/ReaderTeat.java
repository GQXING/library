package com.gqx.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.gqx.dao.impl.BookDaoImpl;
import com.gqx.dao.impl.ReaderDaoImpl;
import com.gqx.entity.Book;

public class ReaderTeat {
	
	 Book book=null;
	 ReaderDaoImpl readerDaoImpl=null;
	//初始化这个对象的实例
	@Before
	public void init(){
		book=new Book();
		readerDaoImpl=new ReaderDaoImpl();
	}
	@Test
	public void test() {
		List<Book> list=readerDaoImpl.getBookByrdID(1007);
		
		for (Book book : list) {
			System.out.println(book);
		}
	}
	@Test
	public void modifyPwd(){
		readerDaoImpl.modifyPwd(1007, "11");
	}

}
