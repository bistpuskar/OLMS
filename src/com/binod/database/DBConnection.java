package com.bhim.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

	public final static String path="jdbc:mysql://localhost:3306/olms";
	public final static String driver="com.mysql.jdbc.Driver";
	public final static String username="root";
	public final static String password="devbinod";
	Connection connection;

	public void open() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		connection=DriverManager.getConnection(path, username, password);
	}
	
	
	public PreparedStatement getPreparedStatement(String query) throws SQLException{
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		return preparedStatement;
	}
	
}
