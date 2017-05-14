package com.bhim.admin.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhim.admin.dao.UserDao;
import com.bhim.admin.entity.User;
import com.bhim.database.DBConnection;

import sun.print.PeekGraphics;


public class UserDaoImpl implements UserDao{

	DBConnection dbConnection =new DBConnection();
	
	@Override
	public List<User> getAllUser() {
		List<User> userlist=new ArrayList<User>();
		ResultSet resultSet;
		String query="select * from `users`";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				User user=new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setUsertype(resultSet.getString("usertype"));
				user.setFirstname(resultSet.getString("firstname"));
				user.setLastname(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setGender(resultSet.getString("gender"));
				user.setRegisterdate(resultSet.getString("registerdate"));
				user.setExpiredate(resultSet.getString("expiredate"));
				userlist.add(user);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userlist;
	}

	@Override
	public void updateUser(User user) {
		String query="update `users` set `username`=?,`password`=?,`firstname`=?,`lastname`=?,`email`=?,`address`=?,`gender`=?,`registerdate`=?,`expiredate`=? where `id`=?";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstname());
			preparedStatement.setString(4, user.getLastname());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getGender());
			preparedStatement.setString(8, user.getRegisterdate());
			preparedStatement.setString(9, user.getExpiredate());
			preparedStatement.setInt(10, user.getId());
			preparedStatement.executeUpdate();
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addUser(User user) {
		String query="insert into `users` (`id`,`username`,`password`,`usertype`,`firstname`,`lastname`,`email`,`address`,`gender`,`registerdate`,`expiredate`) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getUsertype());
			preparedStatement.setString(5, user.getFirstname());
			preparedStatement.setString(6, user.getLastname());
			preparedStatement.setString(7, user.getEmail());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.setString(9, user.getGender());
			preparedStatement.setString(10, user.getRegisterdate());
			preparedStatement.setString(11, user.getExpiredate());
			preparedStatement.executeUpdate();
	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		
		
	}

	@Override
	public void deleteUser(int id) {
		
		String query="delete from `users` where `id`=?";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public User getUser(String username) {

		User user=new User();
		ResultSet resultSet;
		String query="select * from `users` where `username`=?";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1, username);
			
			resultSet=preparedStatement.executeQuery();
			boolean b=resultSet.next();
			if(!b){
				user.setValid(false);
			}
			else if(b){
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setFirstname(resultSet.getString("firstname"));
				user.setLastname(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setGender(resultSet.getString("gender"));
				user.setRegisterdate(resultSet.getString("registerdate"));
				user.setExpiredate(resultSet.getString("expiredate"));	
				user.setValid(true);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int getUserId() {
		int id=0;
		ResultSet resultSet;
		String query="SELECT `id` FROM `users` ORDER BY `id` DESC LIMIT 1";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				id=resultSet.getInt("id");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public User login(User user) {
		String query="select * from `users` where `username`=? and `password`=?";
		ResultSet rs;
		boolean b;
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			rs=preparedStatement.executeQuery();
			b=rs.next();
			if(!b){
	
			user.setValid(false);
			
			}
			else if(b){
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUsertype(rs.getString("usertype"));
				user.setValid(true);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int countrecord() {
		int users=0;
		ResultSet resultSet;
		String query="select count(*) from `users`";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				users = resultSet.getInt("count(*)");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	

}
