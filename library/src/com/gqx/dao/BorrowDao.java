package com.gqx.dao;

import java.util.List;

import com.gqx.entity.Book;
import com.gqx.entity.Borrow;
import com.gqx.entity.CLRClass;
import com.gqx.entity.Reader;
import com.gqx.entity.ReaderType;

public interface BorrowDao {
	//���ݽ� �� ֤ �� ���Ҷ��ߵ���Ϣ
	public Reader getReader(int rdID);
	//����ͼ���Ų���ͼ����Ϣ
	public Book getBook(int bkID);
	//���ݶ�����Ϣ��ͼ����Ϣ��ɽ�����̵Ĵ洢
	public void borrowLend(int rdID,int bkID,String OperatorLend);
	//�����飬��Ҫ��¼�»��������Ա�ͻ���Ķ����Լ�ͼ��//�������
	public void borrowRet(int rdID,int bkID,String OperatorRet);
	//�������
	public Integer lendAgain(int rdID,int bkID);
	//��ȡ���ߵ���ؽ�����Ϣ
	public Borrow getBorrow(int rdID,int bkID);
	//�޸Ĵ��˵Ľ�������
	public void modifyLendNumBook(int rdID,int num);
	//��ȡ��ĳ���ߵĽ�������
	public int getRdBorrowQty(int rdID);
	public ReaderType getReaderType(int rdType);
	//�鿴�Ƿ�����Ƿ����
	public float getallMoney(int rdID);
	//�鿴�Ƿ���Ƿ����
	public float getMoney(int rdID,int bkID);
	//����bkID��ȡͼ����Ϣ
	public Book getBookById(int bkID);
	//��ȡ����ʹ�ø���Ķ���
	public List<CLRClass> getReaderBybkId(int bkID);
	//�ɷ�
	public void punishMoney(int rdID);
}
