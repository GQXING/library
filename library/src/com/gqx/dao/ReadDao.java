package com.gqx.dao;

import java.util.List;

import com.gqx.entity.Book;

public interface ReadDao {
	//根据reader的id来获取借书列表
	public List<Book> getBookByrdID(int rdID);
	//修改密码
	public void modifyPwd(int rdID,String pwd);
	
}
