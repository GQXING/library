package com.gqx.dao;

import java.util.List;

import com.gqx.entity.Book;

public interface ReadDao {
	//����reader��id����ȡ�����б�
	public List<Book> getBookByrdID(int rdID);
	//�޸�����
	public void modifyPwd(int rdID,String pwd);
	
}
