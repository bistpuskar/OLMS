package com.binod.admin.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.UserDao;
import com.binod.admin.daoImpl.UserDaoImpl;
@WebServlet(name="counts",urlPatterns="/counts")
public class CountRecord extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 UserDao userDao=new UserDaoImpl();
		 int users=userDao.countrecord();
		 req.setAttribute("totaluser", users);
		 req.getRequestDispatcher("admin/adminIndex.jsp").forward(req, resp);
	}

}
