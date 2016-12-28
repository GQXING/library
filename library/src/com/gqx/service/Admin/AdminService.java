package com.gqx.service.Admin;

import com.gqx.dao.impl.AdminDaoImpl;

public class AdminService {
	AdminDaoImpl adminDaoImpl=new AdminDaoImpl();
	public void setAdmin(String name,String password, int readerType) {
		adminDaoImpl.setAdmin(name, password, readerType);
	}
}
