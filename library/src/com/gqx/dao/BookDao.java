package com.gqx.dao;

import java.util.List;

import com.gqx.entity.Book;

public interface BookDao {
	//������Ϣ��ȡID
	public int FindBkId(String bkName,String isbnBook);
	//����ͼ��
	public Book checkBook(String bkName,String isbnBook);
	//�޸�ͼ��
	public void modifyBook(Book book);
	//����ͼ��
	public void insertBook(Book book);
	//����ͼ��
	public void deleteBook(String bkName,String isbnBook);
	//����ͼ��id��ȡͼ��
	public Book getBkById(int id); 
	//��ȡ����ͼ��
	public List<Book> getBooks();
}
