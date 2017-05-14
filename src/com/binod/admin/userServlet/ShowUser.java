package com.binod.admin.userServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.UserDao;
import com.binod.admin.daoImpl.UserDaoImpl;
import com.binod.admin.entity.User;

@WebServlet(name="showUser", urlPatterns="/showuser")
public class ShowUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	UserDao userDao=new UserDaoImpl();
	List<User> userlist=userDao.getAllUser();
	req.setAttribute("users", userlist);
	req.getRequestDispatcher("admin/user/showUser.jsp").forward(req, resp);
	

		
	}

}
