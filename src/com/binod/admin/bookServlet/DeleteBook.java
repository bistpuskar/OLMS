package com.binod.admin.bookServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.BookDao;
import com.binod.admin.daoImpl.BookDaoImpl;
import com.binod.admin.entity.Book;
@WebServlet(name="deleteBook", urlPatterns="/deleteBook")
public class DeleteBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BookDao bookDao=new BookDaoImpl();
	bookDao.deleteBook(Integer.parseInt(req.getParameter("bookid")));
	List<Book> booklist=bookDao.getAllBook();
	req.setAttribute("books", booklist);
	req.getRequestDispatcher("admin/book/showBook.jsp").forward(req, resp);
	
	}

}
