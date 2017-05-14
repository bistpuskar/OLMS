package com.binod.admin.userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.UserDao;
import com.binod.admin.daoImpl.UserDaoImpl;
@WebServlet(name="userid", urlPatterns="/userid")
public class GetUserID extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao=new UserDaoImpl();
		req.setAttribute("uid", userDao.getUserId()+1);
		req.getRequestDispatcher("admin/user/addUser.jsp").forward(req, resp);
		
	}

}
