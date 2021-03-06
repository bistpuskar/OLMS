package com.binod.admin.bookServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.BookCategoryDao;
import com.binod.admin.dao.BookDao;
import com.binod.admin.daoImpl.BookCategoryDaoImpl;
import com.binod.admin.daoImpl.BookDaoImpl;
import com.binod.admin.entity.BookCategory;
@WebServlet(name="bookid",urlPatterns="/bookid")
public class GetBookId extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDao bookDao=new BookDaoImpl();
		BookCategoryDao bookCategoryDao=new BookCategoryDaoImpl();
		req.setAttribute("bid", bookDao.getBookId()+1);
		 List<BookCategory> bookcategory=bookCategoryDao.getAllBookCategory();
		 req.setAttribute("category",bookcategory );
		req.getRequestDispatcher("admin/book/addBook.jsp").forward(req, resp);
	}

}
