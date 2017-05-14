package com.binod.admin.dao;

import java.util.List;

import com.binod.admin.entity.Book;
import com.binod.admin.entity.User;

public interface BookIssueReturnDao {
public void issueNewBook(Book book,User user);
public List<Book> getIssuedBook(int user_id);
public void deleteIssueBook(int book_id);
}
