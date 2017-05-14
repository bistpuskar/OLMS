package com.bhim.admin.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhim.admin.dao.BookCategoryDao;
import com.bhim.admin.entity.BookCategory;
import com.bhim.database.DBConnection;

public class BookCategoryDaoImpl implements BookCategoryDao {

	DBConnection dbConnection = new DBConnection();

	@Override
	public void addBookCategory(BookCategory bookCategory) {

		String query = "insert into `bookcategory` (`c_name`) values (?)";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1, bookCategory.getC_name());
			preparedStatement.executeUpdate();
		

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<BookCategory> getAllBookCategory() {
		ResultSet resultSet;
		List<BookCategory> categoryList = new ArrayList<>();
		String query = "select * from `bookcategory`";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BookCategory bookCategory = new BookCategory();
				bookCategory.setC_id(resultSet.getInt("c_id"));
				bookCategory.setC_name(resultSet.getString("c_name"));
				categoryList.add(bookCategory);
			

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return categoryList;
	}

	@Override
	public void updateBookCategory(BookCategory bookCategory) {
		String query="update `bookcategory` set `c_name`=? where `c_id`=?";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1, bookCategory.getC_name());
			preparedStatement.setInt(2, bookCategory.getC_id());
			preparedStatement.executeUpdate();
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void deleteBookCategory(int c_id) {
		String query="delete from `bookcategory` where `c_id`=?";
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, c_id);
			preparedStatement.executeUpdate();
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int getBookCategoryid() {
		ResultSet resultSet;
		int id = 0;
		String query="SELECT `c_id` FROM `bookcategory` ORDER BY `c_id` DESC LIMIT 1";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				id=resultSet.getInt("c_id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

}
