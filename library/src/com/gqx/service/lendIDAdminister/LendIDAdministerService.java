package com.gqx.service.lendIDAdminister;

import com.gqx.dao.impl.UserDaoImpl;
import com.gqx.entity.Reader;

public class LendIDAdministerService {
	private UserDaoImpl userDaoImpl =new UserDaoImpl();
	public Reader checkReader(String name,String dept,String userType){
		return userDaoImpl.check(name, dept, userType);
	}
	public void InsertReader(Reader reader){
		userDaoImpl.insertReader(reader);
	}
	public void update(int rdID,Reader reader){
		userDaoImpl.Update(rdID, reader);
	}
	public Reader reader(int rdID){
		return userDaoImpl.reader(rdID);
	}
	public void logout(int rdID){
		userDaoImpl.logout(rdID);
	}
	public void lost(int rdID){
		userDaoImpl.lost(rdID);
	}
	public void reback(int rdID){
		userDaoImpl.reback(rdID);
	}
	public boolean Update(int rdId,Reader reader){
		return userDaoImpl.Update(rdId, reader);
	}
}
