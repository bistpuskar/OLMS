package com.bhim.admin.transactionServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.UserDao;
import com.bhim.admin.daoImpl.UserDaoImpl;
import com.bhim.admin.entity.User;
@WebServlet(name="searchUsers", urlPatterns="/usersearch")
public class SearchUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao=new UserDaoImpl();
		User user=userDao.getUser(req.getParameter("searchuser").trim());
		
		if(user.isValid()){
		req.setAttribute("usr", user);
		}
		else{
			String messages="Record not found";
			req.setAttribute("messag", messages);
		}
	
		req.getRequestDispatcher("admin/transaction/showIssueBookMember.jsp").forward(req, resp);
	}

}
