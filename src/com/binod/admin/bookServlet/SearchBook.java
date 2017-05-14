package com.bhim.admin.bookServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.BookDao;
import com.bhim.admin.daoImpl.BookDaoImpl;
import com.bhim.admin.entity.Book;
@WebServlet(name="searchBook", urlPatterns="/searchbook")
public class SearchBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		BookDao bookDao=new BookDaoImpl();
		Book book=bookDao.getBook(req.getParameter("searchbook").trim(), req.getParameter("searchbook").trim(), req.getParameter("searchbook").trim(), req.getParameter("searchbook").trim());
	
	if(book.isValidCheck()){
	req.setAttribute("books", book);
	
		}
		else{
			String message="Result not found";
			req.setAttribute("mess", message);
	}
		req.getRequestDispatcher("admin/book/searchBook.jsp").forward(req, resp);
	}

}
