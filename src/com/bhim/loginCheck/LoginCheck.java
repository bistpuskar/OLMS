package com.bhim.loginCheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bhim.admin.dao.BookIssueReturnDao;
import com.bhim.admin.dao.UserDao;
import com.bhim.admin.daoImpl.BookIssueReturnDaoImpl;
import com.bhim.admin.daoImpl.UserDaoImpl;
import com.bhim.admin.entity.User;

@WebServlet(name = "logincheck", urlPatterns = "/logincheck")
public class LoginCheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUsername(req.getParameter("username").trim());
		user.setPassword(req.getParameter("password").trim());
		user = userDao.login(user);
		// count number of user stored in database

		
		int users = userDao.countrecord();

		if (user.isValid()) {
			HttpSession session = req.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("id", user.getId() );

//		if (req.getParameter("type").toLowerCase().trim().equals(user.getUsertype())&&(req.getParameter("type").toLowerCase().trim().equals("admin"))) {
//				req.setAttribute("totaluser", users);
//				req.getRequestDispatcher("admin/adminIndex.jsp").forward(req, resp);
//			}
//			
//		else if (req.getParameter("type").toLowerCase().trim().equals(user.getUsertype())&&(req.getParameter("type").toLowerCase().trim().equals("student"))) {
//				List issuelist=new ArrayList<>();
//				BookIssueReturnDao bookIssueReturnDao=new BookIssueReturnDaoImpl();
//				issuelist=bookIssueReturnDao.getIssuedBook(user.getId());
//				req.setAttribute("userlist", issuelist);
//				req.getRequestDispatcher("student/index.jsp").forward(req, resp);
//			}
//		else {
//			String message = "Username and Password doesnot matched..";
//			req.setAttribute("message", message);
//			req.getRequestDispatcher("login.jsp").forward(req, resp);
//
//		}
//
//			
//		}
			if(user.getUsertype().equals("admin")){
				req.setAttribute("totaluser", users);
				req.getRequestDispatcher("admin/adminIndex.jsp").forward(req, resp);
			}
			if(user.getUsertype().equals("student")){
				List issuelist=new ArrayList<>();
			BookIssueReturnDao bookIssueReturnDao=new BookIssueReturnDaoImpl();
				issuelist=bookIssueReturnDao.getIssuedBook(user.getId());
			req.setAttribute("userlist", issuelist);
				req.getRequestDispatcher("student/index.jsp").forward(req, resp);
			}
			}
//		
		else {
			String message = "Username and Password doesnot matched..";
			req.setAttribute("message", message);
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		}
	}

}
