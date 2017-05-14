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
@WebServlet(name="updateBookCategory", urlPatterns="/updateBookCategory")
public class UpdateBookCategory extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookCategoryDao bookCategoryDao=new BookCategoryDaoImpl();
		BookCategory bookCategory=new BookCategory();
		bookCategory.setC_id(Integer.parseInt(req.getParameter("id")));
		bookCategory.setC_name(req.getParameter("category"));
		bookCategoryDao.updateBookCategory(bookCategory);
		
		
		List<BookCategory> bookcategory=bookCategoryDao.getAllBookCategory();
		req.setAttribute("category", bookcategory );
		
		req.getRequestDispatcher("admin/bookCategory/showBookCategory.jsp").forward(req, resp);
		
		
		
		
	}
	
	
	

}
