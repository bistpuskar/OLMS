package com.binod.admin.bookCategoryServlet;

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

@WebServlet(name="showBookCategory" ,urlPatterns="/showBookCategory")
public class ShowBookCategory  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookCategoryDao bookCategoryDao=new BookCategoryDaoImpl();
		List<BookCategory> bookcategory=bookCategoryDao.getAllBookCategory();
		req.setAttribute("category", bookcategory );
		req.getRequestDispatcher("admin/bookCategory/showBookCategory.jsp").forward(req, resp);
			
		}
		
		
}
