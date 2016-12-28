package com.gqx.service.login;

import com.gqx.dao.impl.UserDaoImpl;
import com.gqx.entity.Reader;
import com.gqx.entity.User;

public class UserService {
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	public int login(User user){
		return userDaoImpl.Login(user);
	}
	//根据读者的的Reader表来登入
	public Reader readerLogin(Reader reader){
		return userDaoImpl.readerLogin(reader);
	}
}
