package com.gqx.dao;

import com.gqx.entity.Reader;
import com.gqx.entity.User;

public interface UserDao {
	//��֤ʡ��
	public int Login(User user);
	//��֤�Ƿ��Ѿ��� ӵ�н���֤
	public String check2(String name,String dept,String userType);
	public Reader check(String name,String dept,String userType);
	public void insertReader(Reader reader);
	//�ɶ���֤�ı��ȥ�޸Ļ���ע�����������ݿ�����ݣ�
	public boolean Update(int rdId,Reader reader);
	//����rdID��ȡ�û�����Ϣ
	public Reader reader(int rdID);
	//ע�����ߵĿ�
	public void logout(int rdID);
	//��ʧ���ߵĿ�
	public void lost(int rdID);
	//�ָ���ʧ
	public void reback(int rdID);
	//���ݶ��ߵĵ�Reader��������
	public Reader readerLogin(Reader reader);
}
