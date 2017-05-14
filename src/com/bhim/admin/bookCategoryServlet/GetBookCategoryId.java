package com.bhim.admin.bookCategoryServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.BookCategoryDao;
import com.bhim.admin.daoImpl.BookCategoryDaoImpl;
@WebServlet(name="categoryid", urlPatterns="/categoryid")
public class GetBookCategoryId extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookCategoryDao bookCategoryDao=new BookCategoryDaoImpl();
		//calling last book category id from database....using getBookCategoryid method...
		req.setAttribute("ids", bookCategoryDao.getBookCategoryid()+1);
		req.getRequestDispatcher("admin/bookCategory/addBookCategory.jsp").forward(req, resp);
	}

}
