package com.binod.admin.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.binod.admin.dao.NotificationDao;
import com.binod.admin.entity.Notification;
import com.binod.database.DBConnection;

public class NotificationDaoImpl implements NotificationDao {
	DBConnection connection=new DBConnection();
	@Override
	public List<Notification> getAllNotification() {
		
		String query="select * from `notification`";
		List<Notification> lists=new ArrayList<Notification>();
		
		ResultSet resultSet;
		
		try {
			connection.open();
			PreparedStatement preparedStatement=connection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Notification notification=new Notification();
				notification.setId(resultSet.getInt("id"));
				notification.setBookname(resultSet.getString("bookname"));
				notification.setMessage(resultSet.getString("message"));
				lists.add(notification);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
		return lists;

	}
	@Override
	public void deleteNotification(int id) {
		String query="delete from `notification` where `id`=?";
		try {
			connection.open();
			PreparedStatement preparedStatement=connection.getPreparedStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
