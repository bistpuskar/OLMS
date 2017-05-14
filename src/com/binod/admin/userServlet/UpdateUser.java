package com.bhim.admin.userServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.UserDao;
import com.bhim.admin.daoImpl.UserDaoImpl;
import com.bhim.admin.entity.User;
@WebServlet(name="updateUser", urlPatterns="/updateuser")
public class UpdateUser  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao=new UserDaoImpl();
		User user=new User();
		user.setId(Integer.parseInt(req.getParameter("userid")));
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setFirstname(req.getParameter("fname"));
		user.setLastname(req.getParameter("lname"));
		user.setEmail(req.getParameter("email"));
		user.setAddress(req.getParameter("address"));
		user.setGender(req.getParameter("gender"));
		user.setRegisterdate(req.getParameter("registerdate"));
		user.setExpiredate(req.getParameter("expiredate"));
		userDao.updateUser(user);
		List<User> userlist=userDao.getAllUser();
		req.setAttribute("users", userlist);
		req.getRequestDispatcher("admin/user/showUser.jsp").forward(req, resp);
		
		
		
	}

	
	
}
