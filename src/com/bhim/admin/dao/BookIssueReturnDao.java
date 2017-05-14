package com.bhim.admin.dao;

import java.util.List;

import com.bhim.admin.entity.Book;
import com.bhim.admin.entity.User;

public interface BookIssueReturnDao {
public void issueNewBook(Book book,User user);
public List<Book> getIssuedBook(int user_id);
public void deleteIssueBook(int book_id);
}
