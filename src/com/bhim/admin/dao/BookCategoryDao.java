package com.bhim.admin.dao;

import java.util.List;

import com.bhim.admin.entity.BookCategory;

public interface BookCategoryDao {

	public List<BookCategory> getAllBookCategory();

	public void addBookCategory(BookCategory bookCategory);
	
	public void updateBookCategory(BookCategory bookCategory);
	
	public void deleteBookCategory(int c_id);
	public int getBookCategoryid();

}
