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
@WebServlet(name="returnBook", urlPatterns="/returnbooks")
public class ReturnBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Book> lists=new ArrayList<Book>();
		BookIssueReturnDao bookIssueReturnDao=new BookIssueReturnDaoImpl();
		bookIssueReturnDao.deleteIssueBook(Integer.parseInt(req.getParameter("issueid")));
		lists=bookIssueReturnDao.getIssuedBook(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("issuelist", lists);
		req.setAttribute("user", req.getParameter("names"));
		req.setAttribute("ids", req.getParameter("id").trim());
		
		req.getRequestDispatcher("admin/transaction/newIssueBook.jsp").forward(req, resp);
	}



}
