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
@WebServlet(name="updateBook", urlPatterns="/updateBook")
public class UpdateBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BookDao bookDao=new BookDaoImpl();
	Book book=new Book();
	book.setB_id(Integer.parseInt(req.getParameter("bookid")));
	book.setB_name(req.getParameter("bookname"));
	book.setB_author(req.getParameter("authorname"));
	book.setB_isbn(req.getParameter("isbn"));
	book.setB_publication(req.getParameter("publicationname"));
	book.setB_publication_year(req.getParameter("publicationyear"));
	book.setB_purchase_date(req.getParameter("purchasedate"));
	book.setB_category(req.getParameter("bookcategory"));
	book.setB_number(req.getParameter("booknumber"));
	book.setB_cost(req.getParameter("bookcost"));
	bookDao.updateBook(book);
	//Call getAllBook method for to fetch all record form database
	List<Book> booklist=bookDao.getAllBook();
	req.setAttribute("books", booklist);
	
	req.getRequestDispatcher("admin/book/showBook.jsp").forward(req, resp);
	
		
		
	}
	
	

}
