package com.gqx.service.login;

import com.gqx.dao.impl.UserDaoImpl;
import com.gqx.entity.Reader;
import com.gqx.entity.User;

public class UserService {
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	public int login(User user){
		return userDaoImpl.Login(user);
	}
	//���ݶ��ߵĵ�Reader��������
	public Reader readerLogin(Reader reader){
		return userDaoImpl.readerLogin(reader);
	}
}
