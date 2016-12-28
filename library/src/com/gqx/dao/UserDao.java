package com.gqx.dao;

import com.gqx.entity.Reader;
import com.gqx.entity.User;

public interface UserDao {
	//验证省份
	public int Login(User user);
	//验证是否已经被 拥有借书证
	public String check2(String name,String dept,String userType);
	public Reader check(String name,String dept,String userType);
	public void insertReader(Reader reader);
	//由读者证的编号去修改或者注销（更改数据库的内容）
	public boolean Update(int rdId,Reader reader);
	//根据rdID获取用户的信息
	public Reader reader(int rdID);
	//注销读者的卡
	public void logout(int rdID);
	//挂失读者的卡
	public void lost(int rdID);
	//恢复挂失
	public void reback(int rdID);
	//根据读者的的Reader表来登入
	public Reader readerLogin(Reader reader);
}
