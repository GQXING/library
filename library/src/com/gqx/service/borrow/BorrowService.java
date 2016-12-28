package com.gqx.service.borrow;

import java.util.List;

import com.gqx.dao.impl.BorrowDaoImpl;
import com.gqx.entity.Book;
import com.gqx.entity.Borrow;
import com.gqx.entity.CLRClass;
import com.gqx.entity.Reader;

public class BorrowService {
	BorrowDaoImpl borrow=new BorrowDaoImpl();
	public Reader getReader(int rdID){
		return borrow.getReader(rdID);
	}
	public Book getBook(int bkID){
		return borrow.getBook(bkID);
	}
	public void borrowLend(int rdID,int bkID,String OperatorLend){
		borrow.borrowLend(rdID, bkID, OperatorLend);
	}

	public void borrowRet(int rdID,int bkID,String OperatorRet){
		borrow.borrowRet(rdID, bkID, OperatorRet);
	}

	public String lendAgain(int rdID,int bkID){
		int result=borrow.lendAgain(rdID, bkID);
		if (result==0) {
			return "����ɹ���";
		}else {
			return "����ʧ�ܣ�";
		}
	}

	public Borrow getBorrow(int rdID,int bkID){
		return borrow.getBorrow(rdID, bkID);
	}
	public int getRdBorrowQty(int rdID){
		return borrow.getRdBorrowQty(rdID);
	}
	//�ж��Ƿ����鳬��������
	public String getQtyStatus(int rdID){
		int n=borrow.getRdBorrowQty(rdID);
		int rdType=borrow.getReader(rdID).getRdType();
		int m=borrow.getReaderType(rdType).getCanLendQty();
		if (n>=m) {
			return "�ѽ�ͼ��ﵽ������";
		}else {
			return "�ɽ�";
		}
	}
	//�鿴�Ƿ���Ƿ����
	public float getMoney(int rdID,int bkID){
		return borrow.getMoney(rdID, bkID);
	}
	//�鿴�Ƿ�����Ƿ����
	public float getallMoney(int rdID){
		return borrow.getallMoney(rdID);
	}
	//����bkID��ȡͼ����Ϣ
	public Book getBookById(int bkID){
		return borrow.getBookById(bkID);
	}
	//��ȡ����ʹ�ø���Ķ���
	public List<CLRClass> getReaderBybkId(int bkID){
		return borrow.getReaderBybkId(bkID);
	}
	//�ɷ�
	public void punishMoney(int rdID){
		borrow.punishMoney(rdID);
	}
}
