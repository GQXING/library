package com.gqx.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;







import com.gqx.dao.BorrowDao;
import com.gqx.dao.impl.BorrowDaoImpl;
import com.gqx.entity.Book;
import com.gqx.entity.Borrow;
import com.gqx.entity.CLRClass;
import com.gqx.entity.Reader;
import com.gqx.service.borrow.BorrowService;

public class BorrowTest {
	Borrow borrow=null;
	BorrowDao borrowDao=null;
	@Before
	public void init(){
		borrowDao=new BorrowDaoImpl();
		borrow=new Borrow();
	}
	@Test
	public void testborrowLend() {
		//int rdID,int bkID,String operatorLend
		borrowDao.borrowLend(1006, 4, "admin");
	}
	@Test
	public void getReader() {
		//int rdID,int bkID,String operatorLend
		Reader reader=borrowDao.getReader(1007);
		Book book=borrowDao.getBook(1);
		System.out.println(reader);
		System.out.println(book);
	}
	
	@Test
	public void borrowRet(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		borrowDao.borrowRet(1007, 1, "admin2");
	}
	
	@Test
	public void lendAgain(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		System.out.println(borrowDao.lendAgain(1006, 4));
	}
	
	@Test
	public void getBorrow(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		System.out.println(borrowDao.getBorrow(1006, 4));
	}
	@Test
	public void getBorrow3(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		int s=borrowDao.getRdBorrowQty(1003);
		System.out.println(s);
		borrowDao.modifyLendNumBook(1003,1);
		s=borrowDao.getRdBorrowQty(1003);
		System.out.println(s);
	}
	
	@Test
	public void getBorrowString(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		BorrowService service=new BorrowService();
		System.out.println(service.getQtyStatus(1003));
	}
	@Test
	public void getBorrowMoney(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		BorrowService service=new BorrowService();
		System.out.println(service.getMoney(1007, 1));
	}
	
	@Test
	public void getBorrowAllMoney(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		
		System.out.println(borrowDao.getallMoney(1007));
	}
	@Test
	public void ListTest(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		BorrowService service=new BorrowService();
		List<CLRClass> list=service.getReaderBybkId(4);
		for (CLRClass clrClass : list) {
			System.out.println(clrClass);
		}
	}
	
	@Test
	public void MoneyTest(){
		//borrowRet  int rdID,int bkID,String OperatorRet
		borrowDao.punishMoney(1007);
	}

}
