package com.gqx.service.reader;

import java.util.List;

import com.gqx.dao.impl.ReaderDaoImpl;
import com.gqx.entity.Book;

public class ReaderService {
	ReaderDaoImpl readerDaoImpl=new ReaderDaoImpl();
	//����reader��id����ȡ�����б�
	public List<Book> getBookByrdID(int rdID){
		return readerDaoImpl.getBookByrdID(rdID);
	}
	//�޸�����
	public void modifyPwd(int rdID,String pwd){
		readerDaoImpl.modifyPwd(rdID, pwd);
	}

}
