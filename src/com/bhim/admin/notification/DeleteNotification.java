package com.bhim.admin.notification;

import java.io.IOException;
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

@WebServlet(name = "deleteNotification", urlPatterns = "/deleteNotification")
public class DeleteNotification extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NotificationDao notification = new NotificationDaoImpl();
		notification.deleteNotification(Integer.parseInt(req.getParameter("deleteid")));
		List<Notification> list=new ArrayList<Notification>();
	
		list=notification.getAllNotification();
		req.setAttribute("nlist", list);
		req.getRequestDispatcher("admin/notification/notification.jsp").forward(req, resp);

	}

}
