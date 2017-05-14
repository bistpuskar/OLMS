package com.bhim.admin.bookServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.BookCategoryDao;
import com.bhim.admin.dao.BookDao;
import com.bhim.admin.daoImpl.BookCategoryDaoImpl;
import com.bhim.admin.daoImpl.BookDaoImpl;
import com.bhim.admin.entity.Book;
import com.bhim.admin.entity.BookCategory;
@WebServlet(name="addBook", urlPatterns="/addbook")
public class AddBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Book book=new Book();
		BookDao bookDao=new BookDaoImpl();
		
	
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
		bookDao.addBook(book);
		//call method to display getAll for to display all record in jsp
		
		List<Book> booklist=bookDao.getAllBook();
		req.setAttribute("books", booklist);
		
		
		req.getRequestDispatcher("admin/book/showBook.jsp").forward(req, resp);
	}

}
