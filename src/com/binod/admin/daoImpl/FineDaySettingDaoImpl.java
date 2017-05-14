package com.binod.admin.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.binod.admin.dao.FineDaySettingDao;
import com.binod.admin.entity.FinePerDaySetting;
import com.binod.database.DBConnection;

public class FineDaySettingDaoImpl implements FineDaySettingDao {
	DBConnection dbConnection = new DBConnection();

	@Override
	public void addFinePerDay(FinePerDaySetting setting) {
		String query = "update `finesetting` set `fineperday`=?";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, setting.getFinePerDay());
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public FinePerDaySetting getAlldays() {

		
		ResultSet resultSet;
		String query = "select * from `finesetting`";
		FinePerDaySetting daysSetting=new FinePerDaySetting();
		try {
			dbConnection.open();
			PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				
				daysSetting.setFinePerDay(resultSet.getInt("fineperday"));
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return daysSetting;
	}

}
