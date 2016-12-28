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
			return "续借成功！";
		}else {
			return "续借失败！";
		}
	}

	public Borrow getBorrow(int rdID,int bkID){
		return borrow.getBorrow(rdID, bkID);
	}
	public int getRdBorrowQty(int rdID){
		return borrow.getRdBorrowQty(rdID);
	}
	//判断是否有书超过借书两
	public String getQtyStatus(int rdID){
		int n=borrow.getRdBorrowQty(rdID);
		int rdType=borrow.getReader(rdID).getRdType();
		int m=borrow.getReaderType(rdType).getCanLendQty();
		if (n>=m) {
			return "已借图书达到了上限";
		}else {
			return "可借";
		}
	}
	//查看是否拖欠费用
	public float getMoney(int rdID,int bkID){
		return borrow.getMoney(rdID, bkID);
	}
	//查看是否有拖欠费用
	public float getallMoney(int rdID){
		return borrow.getallMoney(rdID);
	}
	//根据bkID获取图书信息
	public Book getBookById(int bkID){
		return borrow.getBookById(bkID);
	}
	//获取所有使用该书的读者
	public List<CLRClass> getReaderBybkId(int bkID){
		return borrow.getReaderBybkId(bkID);
	}
	//缴费
	public void punishMoney(int rdID){
		borrow.punishMoney(rdID);
	}
}
