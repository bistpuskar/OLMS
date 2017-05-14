package com.bhim.student.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.BookDao;
import com.bhim.admin.daoImpl.BookDaoImpl;
import com.bhim.admin.entity.Book;
@WebServlet(name="sbook", urlPatterns="/sbook")
public class ShowBookStudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookDao bookDao=new BookDaoImpl();
		List<Book> list=bookDao.getAllBook();
		req.setAttribute("booklist", list);
		req.getRequestDispatcher("student/showBookStudent.jsp").forward(req, resp);
	}

}
