package com.binod.admin.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

import com.binod.admin.dao.BookDao;
import com.binod.admin.dao.ReturnDateSettingDao;
import com.binod.admin.entity.Book;
import com.binod.admin.entity.FineCalculation;
import com.binod.admin.entity.ReturnDateSetting;
import com.binod.database.DBConnection;

public class BookDaoImpl implements BookDao {
	
DBConnection dbConnection=new  DBConnection();
	@Override
	public List<Book> getAllBook() {
	List<Book> booklist=new ArrayList<Book>();
	String query="select * from `book`";
	
	try {
		ResultSet resultSet;
		dbConnection.open();
		PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
		resultSet=	preparedStatement.executeQuery();
		while(resultSet.next()){
			Book book=new Book();
			book.setB_id(resultSet.getInt("b_id"));
			book.setB_name(resultSet.getString("b_name"));
			book.setB_author(resultSet.getString("b_author"));
			book.setB_isbn(resultSet.getString("b_isbn"));
			book.setB_publication(resultSet.getString("b_publication"));
			book.setB_publication_year(resultSet.getString("b_publication_year"));
			book.setB_purchase_date(resultSet.getString("b_purchase_date"));
			book.setB_category(resultSet.getString("b_category"));
			book.setB_cost(resultSet.getString("b_cost"));
			book.setB_number(resultSet.getString("b_number"));
			booklist.add(book);
		}
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return booklist;
	}
	@Override
	public void updateBook(Book book) {
		//String query="update `book` set `b_name`=?,`b_author`=?,`b_isbn`=?,`b_publication`=?,`b_publication_year`=?,`b_purchase_date`=?,`b_category`=?,`b_cost`=?,`b_number`=? where b_id=?";
		String query="update `book` set `b_name`=?,`b_author`=?,`b_isbn`=?,`b_publication`=?,`b_publication_year`=?,`b_purchase_date`=?,`b_category`=?,`b_cost`=?,`b_number`=? where `b_id`=?";
		try {
			dbConnection.open();
			
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1, book.getB_name());
			preparedStatement.setString(2, book.getB_author());
			preparedStatement.setString(3, book.getB_isbn());
			preparedStatement.setString(4, book.getB_publication());
			preparedStatement.setString(5, book.getB_publication_year());
			preparedStatement.setString(6, book.getB_purchase_date());
			preparedStatement.setString(7, book.getB_category());
			preparedStatement.setString(8, book.getB_cost());
			preparedStatement.setString(9, book.getB_number());
			preparedStatement.setInt(10, book.getB_id());
		
			preparedStatement.executeUpdate();
		
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public void deleteBook(int b_id) {
		String query="delete from `book` where `b_id`=?";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, b_id);
			preparedStatement.executeUpdate();
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void addBook(Book book) {
		String query="insert into `book` (`b_id`,`b_name`,`b_author`,`b_isbn`,`b_publication`,`b_publication_year`,`b_purchase_date`,`b_category`,`b_cost`,`b_number`) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, book.getB_id());
			preparedStatement.setString(2, book.getB_name());
			preparedStatement.setString(3, book.getB_author());
			preparedStatement.setString(4, book.getB_isbn());
			preparedStatement.setString(5, book.getB_publication());
			preparedStatement.setString(6, book.getB_publication_year());
			preparedStatement.setString(7, book.getB_purchase_date());
			preparedStatement.setString(8, book.getB_category());
			preparedStatement.setString(9, book.getB_cost());
			preparedStatement.setString(10, book.getB_number());
			preparedStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public Book getBook(String b_name, String b_author, String b_isbn, String b_publication) {
		Book book=new Book();
		String query="select * from `book` where `b_name`=? or `b_author`=? or `b_isbn`=? or `b_publication`=?";
		ResultSet resultSet;
		boolean checkdata;
		
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1,b_name);
			preparedStatement.setString(2, b_author);
			preparedStatement.setString(3,b_isbn);
			preparedStatement.setString(4, b_publication);
			resultSet=preparedStatement.executeQuery();
			checkdata=resultSet.next();
			if(!checkdata){
				book.setValidCheck(false);
				
			}
			else if (checkdata){
			
				book.setB_id(resultSet.getInt("b_id"));
				book.setB_name(resultSet.getString("b_name"));
				book.setB_author(resultSet.getString("b_author"));
				book.setB_isbn(resultSet.getString("b_isbn"));
				book.setB_publication(resultSet.getString("b_publication"));
				book.setB_publication_year(resultSet.getString("b_publication_year"));
				book.setB_purchase_date(resultSet.getString("b_purchase_date"));
				book.setB_category(resultSet.getString("b_category"));
				book.setB_cost(resultSet.getString("b_cost"));
				book.setB_number(resultSet.getString("b_number"));	
				book.setValidCheck(true);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;
	}
	@Override
	public Book getSingleBook(String b_name) {
		Book book=new Book();
		boolean b;
		FineCalculation calculation=new FineCalculation();
		ResultSet resultSet;
		String query="select * from `book` where `b_name`=?";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setString(1, b_name);
			resultSet=preparedStatement.executeQuery();
			b=resultSet.next();
			if(!b){
				book.setValidCheck(false);
			}
			else if (b){
				book.setB_id(resultSet.getInt("b_id"));
				book.setB_name(resultSet.getString("b_name"));
				book.setB_author(resultSet.getString("b_author"));
				book.setB_isbn(resultSet.getString("b_isbn"));
				book.setB_publication(resultSet.getString("b_publication"));
				book.setB_publication_year(resultSet.getString("b_publication_year"));
				book.setB_category(resultSet.getString("b_category"));
				// for fine system
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(new Date()); // Now use today date.
				String issue = sdf.format(c.getTime());
				
				//add Date dynamically so we call value form database table
				//so we call Return day from database ....with table RETURNDAYSETTING
				//now we call method inside ReturnDateSetingDaoImpl class
				
				ReturnDateSettingDao returnDateSettingDao=new ReturnDateSettingDaoImpl();
				ReturnDateSetting returnDateSetting=returnDateSettingDao.getDate();
				
				c.add(Calendar.DATE, returnDateSetting.getReturndate()); // Adding 5 days
				String returns = sdf.format(c.getTime());
				
				book.setIssuedate(issue);
				book.setReturndate(returns);
				book.setValidCheck(true);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return book;
	}
	@Override
	public int getBookId() {
		int id=0;
		ResultSet resultSet;
		String query="SELECT `b_id` FROM `book` ORDER BY `b_id` DESC LIMIT 1";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				id=resultSet.getInt("b_id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	

}
