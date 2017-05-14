package com.binod.student.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.BookDao;
import com.binod.admin.daoImpl.BookDaoImpl;
import com.binod.admin.entity.Book;
@WebServlet(name="studentBook",urlPatterns="/books")
public class SearchBookStudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		BookDao bookDao=new BookDaoImpl();
		Book book=bookDao.getSingleBook(req.getParameter("searchbook").trim());
		if(book.isValidCheck()){
			req.setAttribute("booklist", book);
		}
		else{
			String message="Book not Found";
			req.setAttribute("messg", message);
		}
		
		
	req.getRequestDispatcher("student/searchBookStudent.jsp").forward(req, resp);
	}

}
