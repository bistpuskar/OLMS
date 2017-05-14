package com.bhim.admin.notification;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhim.database.DBConnection;
@WebServlet(name="notification",urlPatterns="/notification")
public class UserNotification extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DBConnection connection=new DBConnection();
		String query="insert into `notification` (`bookname`,`message`) values(?,?)";
		try {
			connection.open();
			PreparedStatement preparedStatement=connection.getPreparedStatement(query);
			preparedStatement.setString(1, req.getParameter("bookname"));
			preparedStatement.setString(2, req.getParameter("usernames"));
		
			preparedStatement.executeUpdate();
			String message="Sucessfully Requested..";
			req.setAttribute("messagenotification", message);
			
			req.getRequestDispatcher("student/index.jsp").forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
