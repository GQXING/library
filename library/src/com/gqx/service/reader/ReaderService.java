package com.gqx.service.reader;

import java.util.List;

import com.gqx.dao.impl.ReaderDaoImpl;
import com.gqx.entity.Book;

public class ReaderService {
	ReaderDaoImpl readerDaoImpl=new ReaderDaoImpl();
	//根据reader的id来获取借书列表
	public List<Book> getBookByrdID(int rdID){
		return readerDaoImpl.getBookByrdID(rdID);
	}
	//修改密码
	public void modifyPwd(int rdID,String pwd){
		readerDaoImpl.modifyPwd(rdID, pwd);
	}

}
