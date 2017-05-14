package com.binod.student.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.BookCategoryDao;
import com.binod.admin.daoImpl.BookCategoryDaoImpl;
import com.binod.admin.entity.BookCategory;
@WebServlet(name="sbookCategory", urlPatterns="/sbookCategory")
public class ShowBookCategoryStudent extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookCategoryDao bookCategoryDao=new BookCategoryDaoImpl();
		List<BookCategory> categorylist=bookCategoryDao.getAllBookCategory();
		req.setAttribute("clist", categorylist);
		req.getRequestDispatcher("student/showBookCategoryStudent.jsp").forward(req, resp);
		
	}

}
