package com.binod.admin.transactionServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.BookIssueReturnDao;
import com.binod.admin.daoImpl.BookIssueReturnDaoImpl;
import com.binod.admin.entity.Book;
import com.binod.admin.entity.User;

@WebServlet(name = "issueBook", urlPatterns = "/issueBook")
public class IssueBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Book> lists = new ArrayList<Book>();
		Book book = new Book();
		User user = new User();
		BookIssueReturnDao bookIssueReturnDao = new BookIssueReturnDaoImpl();
		user.setId(Integer.parseInt(req.getParameter("id")));
		book.setB_id(Integer.parseInt(req.getParameter("book_id")));
		book.setB_name(req.getParameter("book_name"));
		book.setB_author(req.getParameter("book_author"));
		book.setB_isbn(req.getParameter("book_isbn"));
		book.setB_publication(req.getParameter("book_publication"));
		book.setIssuedate(req.getParameter("book_issue"));
		book.setReturndate(req.getParameter("book_return"));
		bookIssueReturnDao.issueNewBook(book, user);

		lists = bookIssueReturnDao.getIssuedBook(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("issuelist", lists);

		// form member name and ids

		if (user.isValid()) {
			req.setAttribute("user", req.getParameter("names"));
			req.setAttribute("ids", req.getParameter("id").trim());
			req.getRequestDispatcher("admin/transaction/newIssueBook.jsp").forward(req, resp);
		} else {
			String message = "Your already issue 5 Book";
			req.setAttribute("messag", message);
			req.setAttribute("user", req.getParameter("names"));
			req.setAttribute("ids", req.getParameter("id").trim());
			req.getRequestDispatcher("admin/transaction/newIssueBook.jsp").forward(req, resp);
		}
	}

}
