package com.bhim.admin.bookCategoryServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.BookCategoryDao;
import com.bhim.admin.daoImpl.BookCategoryDaoImpl;
import com.bhim.admin.entity.BookCategory;

@WebServlet(name="Book Category" ,urlPatterns="/addBookCategory")
public class AddBookCategory extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	BookCategoryDao bookCategoryDao=new BookCategoryDaoImpl();
    BookCategory bookCategory=new BookCategory();
    bookCategory.setC_name(req.getParameter("category"));
	bookCategoryDao.addBookCategory(bookCategory);
	List<BookCategory> bookcategory=bookCategoryDao.getAllBookCategory();
	req.setAttribute("category", bookcategory );
	List a=(List) req.getAttribute("category");
	req.getRequestDispatcher("admin/bookCategory/showBookCategory.jsp").forward(req, resp);
	
	
	}

	
}
