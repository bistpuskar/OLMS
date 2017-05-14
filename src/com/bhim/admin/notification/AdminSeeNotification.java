package com.bhim.admin.notification;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.admin.dao.NotificationDao;
import com.bhim.admin.daoImpl.NotificationDaoImpl;
import com.bhim.admin.entity.Notification;
import com.bhim.database.DBConnection;

@WebServlet(name = "seenotification", urlPatterns = "/seenotification")
public class AdminSeeNotification extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Notification> list=new ArrayList<Notification>();
		NotificationDao notificationDao=new NotificationDaoImpl();
		list=notificationDao.getAllNotification();
		req.setAttribute("nlist", list);
		
		req.getRequestDispatcher("admin/notification/notification.jsp").forward(req, resp);
	}	

}
