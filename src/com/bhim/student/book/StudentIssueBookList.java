package com.bhim.student.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.BookIssueReturnDao;
import com.bhim.admin.daoImpl.BookIssueReturnDaoImpl;
@WebServlet(name="SBooklist",urlPatterns="/SBooklist")
public class StudentIssueBookList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List issuelist=new ArrayList<>();
		BookIssueReturnDao bookIssueReturnDao=new BookIssueReturnDaoImpl();
		issuelist=bookIssueReturnDao.getIssuedBook(Integer.parseInt(req.getParameter("userid").trim()));
		req.setAttribute("userlist", issuelist);
		req.getRequestDispatcher("student/index.jsp").forward(req, resp);
	}

}
