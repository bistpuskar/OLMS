package com.binod.admin.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.binod.admin.dao.BookIssueReturnDao;
import com.binod.admin.dao.FineDaySettingDao;
import com.binod.admin.entity.Book;
import com.binod.admin.entity.FinePerDaySetting;
import com.binod.admin.entity.User;
import com.binod.database.DBConnection;

public class BookIssueReturnDaoImpl implements BookIssueReturnDao {
	DBConnection dbConnection = new DBConnection();

	@Override
	public void issueNewBook(Book book, User user) {
		
		String issuelist = "select count(*) from `transaction` where `memberid`=?";
		int booklist = 0;
		int bookname = 0;
		String query1 = "select * from `transaction` where `memberid`=?";
		ResultSet resultSet;
		ResultSet resultSet2;

		try {
			dbConnection.open();
			PreparedStatement preparedStatement = dbConnection.getPreparedStatement(issuelist);
			PreparedStatement preparedStatement2 = dbConnection.getPreparedStatement(query1);
			preparedStatement2.setInt(1, user.getId());
			preparedStatement.setInt(1, user.getId());
			resultSet = preparedStatement.executeQuery();
			resultSet2 = preparedStatement2.executeQuery();

			while (resultSet.next()) {
				booklist = resultSet.getInt("count(*)");
			}

			while (resultSet2.next()) {
				bookname = resultSet2.getInt("bookid");

			}

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("your issue book list are" + booklist);
		if (bookname == book.getB_id()) {
			System.out.println("already registered...");
			user.setValid2(false);
			
			
		} else{

			if (booklist > 4) {
				System.out.println("sorry you already issue 5 book");
				user.setValid(false);
			}

			else {
				String query = "insert into `transaction` (`issuedate`,`returndate`,`bookid`,`memberid`) values(?,?,?,?)";
				// String query = "insert into `transaction`
				// (`issuedate`,`returndate`,`bookid`) values(?,?,?)";

				try {
					dbConnection.open();
					PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
					preparedStatement.setString(1, book.getIssuedate());
					preparedStatement.setString(2, book.getReturndate());
					preparedStatement.setInt(3, book.getB_id());
					preparedStatement.setInt(4, user.getId());
					preparedStatement.executeUpdate();
					user.setValid(true);

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public List<Book> getIssuedBook(int user_id) {
		long fine, fineDay;
		String query = "select `b_id`,`b_name`,`b_author`,`b_isbn`,`b_publication`,`issuedate`,`returndate` from `book` INNER JOIN `transaction` where `book`.`b_id`=`transaction`.`bookid` AND `transaction`.`memberid`=?";
		ResultSet resultSet;
		List<Book> issuelist = new ArrayList<Book>();
		try {
			dbConnection.open();
			PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, user_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Book book = new Book();
				book.setB_id(resultSet.getInt("b_id"));
				book.setB_name(resultSet.getString("b_name"));
				book.setB_author(resultSet.getString("b_author"));
				book.setB_isbn(resultSet.getString("b_isbn"));
				book.setB_publication(resultSet.getString("b_publication"));
				book.setIssuedate(resultSet.getString("issuedate"));
				book.setReturndate(resultSet.getString("returndate"));

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date issueDate = sdf.parse(resultSet.getString("issuedate")); // retrieve
																				// issuedate
				Date returnDate = sdf.parse(resultSet.getString("returndate")); // retrieve
																				// duedate
				Calendar c = Calendar.getInstance();
				c.setTime(new Date());
				Date todays = c.getTime();
			
				if (todays.getTime() > returnDate.getTime()) {

					fine = Math.abs(todays.getTime() - returnDate.getTime());
					long days = fine / (24 * 60 * 60 * 1000);
					// Calling FineRate From database FineSetting table ....
					// With DaoImpl method....Call to retrieve
					FineDaySettingDao fineDaySettingDao = new FineDaySettingDaoImpl();
					FinePerDaySetting daySetting = fineDaySettingDao.getAlldays();
					fineDay = days * daySetting.getFinePerDay();
					book.setFine(fineDay);
				} else {
					fineDay = 0;
				}

				issuelist.add(book);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return issuelist;
	}

	@Override
	public void deleteIssueBook(int book_id) {
		String query = "delete from `transaction` where `bookid`=?";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, book_id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
