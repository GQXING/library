package com.gqx.dao;

import java.util.List;

import com.gqx.entity.Book;
import com.gqx.entity.Borrow;
import com.gqx.entity.CLRClass;
import com.gqx.entity.Reader;
import com.gqx.entity.ReaderType;

public interface BorrowDao {
	//根据借 书 证 名 查找读者的信息
	public Reader getReader(int rdID);
	//根据图书标号查找图书信息
	public Book getBook(int bkID);
	//根据读者信息和图书信息完成借书过程的存储
	public void borrowLend(int rdID,int bkID,String OperatorLend);
	//若还书，需要记录下还书操作人员和还书的读者以及图书//还书操作
	public void borrowRet(int rdID,int bkID,String OperatorRet);
	//续借操作
	public Integer lendAgain(int rdID,int bkID);
	//获取读者的相关借书信息
	public Borrow getBorrow(int rdID,int bkID);
	//修改此人的借书数量
	public void modifyLendNumBook(int rdID,int num);
	//获取该某读者的借书数量
	public int getRdBorrowQty(int rdID);
	public ReaderType getReaderType(int rdType);
	//查看是否有拖欠费用
	public float getallMoney(int rdID);
	//查看是否拖欠费用
	public float getMoney(int rdID,int bkID);
	//根据bkID获取图书信息
	public Book getBookById(int bkID);
	//获取所有使用该书的读者
	public List<CLRClass> getReaderBybkId(int bkID);
	//缴费
	public void punishMoney(int rdID);
}
