package com.bhim.admin.dao;

import java.util.List;

import com.bhim.admin.entity.Book;

public interface BookDao {
	public List<Book> getAllBook();
	public void updateBook(Book book);
	public void deleteBook(int b_id);
	public void addBook(Book book);
	public Book getBook(String b_name, String b_author,String b_isbn, String b_publication);
	public Book getSingleBook(String b_name);
	public int getBookId();
}
