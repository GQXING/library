package com.gqx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import com.gqx.dao.BookDao;
import com.gqx.entity.Book;
import com.gqx.entity.User;
import com.gqx.util.JDBCUtil;
import com.gqx.util.JUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public Book checkBook(String bkName, String isbnBook) {
		// TODO Auto-generated method stub
		String sql="select * from TB_Book where bkName=? and bkISBN=?";
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		try {
			List<Book> list=runner.query(sql, new BeanListHandler<Book>(Book.class),bkName,isbnBook);
			
			if (!list.isEmpty()) {
				return list.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void modifyBook(Book book) {
		// TODO Auto-generated method stub
		Connection connection =JUtil.getConnection();
		PreparedStatement statement=null;
		String sql="update TB_Book set bkName=?,bkAuthor=?,bkPress=?,bkDatePress=?,bkISBN=?,bkLanguage=?,bkPages=?,bkPrice=?,bkBrief=?,bkStatus=? where bkID=?";
		//,rdSex=?,rdType=?,rdDept=?,rdPhone=?,rdStatus=?,rdPwd=? 
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, book.getBkName());
			statement.setString(2, book.getBkAuthor());
			statement.setString(3, book.getBkPress());
			statement.setDate(4, book.getBkDatePress());
			statement.setString(5, book.getBkISBN());
			statement.setInt(6, book.getBkLanguage());
			statement.setInt(7, book.getBkPages());
			statement.setFloat(8, book.getBkPrice());
			statement.setString(9, book.getBkBrief());
			statement.setString(10, book.getBkStatus());
			statement.setInt(11, book.getBkID());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertBook(Book book) {
		// TODO Auto-generated method stub
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		String sql="insert into TB_Book (bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkLanguage,bkPages,bkPrice,bkBrief) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			Map<String,Object> insertRs = runner.insert(sql,new MapHandler(),
					book.getBkCode(),book.getBkName(),book.getBkAuthor(),book.getBkPress(),book.getBkDatePress(),book.getBkISBN(),
					book.getBkLanguage(),book.getBkPages(),book.getBkPrice(),book.getBkBrief());
			System.out.println("MapHandler:" + insertRs.get("GENERATED_KEYS"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(String bkName, String isbnBook) {
		// TODO Auto-generated method stub
		QueryRunner runner=JDBCUtil.getQuerrRunner();
		int id=this.FindBkId(bkName, isbnBook);
		String sql="delete from TB_Book where bkID="+id;
		try {
			runner.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int FindBkId(String bkName, String isbnBook) {
		// TODO Auto-generated method stub
		String sql="select bkID from TB_Book where bkName=? and bkISBN=?";
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		try {
			Book book=runner.query(sql, new BeanHandler<Book>(Book.class),bkName,isbnBook);
			return book.getBkID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	@Override
	public Book getBkById(int id) {
		String sql="select * from TB_Book where bkID=?";
		QueryRunner runner =JDBCUtil.getQuerrRunner();
		try {
			Book book=runner.query(sql, new BeanHandler<Book>(Book.class),id);
			return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		String sql="select * from TB_Book";
		try {
			return JDBCUtil.getQuerrRunner().query(sql,new BeanListHandler<Book>(Book.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
