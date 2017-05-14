package com.bhim.admin.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bhim.admin.dao.ReturnDateSettingDao;
import com.bhim.admin.entity.ReturnDateSetting;
import com.bhim.database.DBConnection;

public class ReturnDateSettingDaoImpl implements ReturnDateSettingDao{
DBConnection dbConnection=new DBConnection();
	@Override
	public void updateDate(int returndate) {
		String query="update `returndaysetting` set `returndate`=?";
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			preparedStatement.setInt(1, returndate);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public ReturnDateSetting getDate() {
		String query="select * from `returndaysetting`";
		ReturnDateSetting dateSetting=new ReturnDateSetting();
		ResultSet resultSet;
		try {
			dbConnection.open();
			PreparedStatement preparedStatement=dbConnection.getPreparedStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				dateSetting.setReturndate(resultSet.getInt("returndate"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  dateSetting;
	}

}
