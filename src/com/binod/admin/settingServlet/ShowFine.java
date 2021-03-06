package com.binod.admin.settingServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.FineDaySettingDao;
import com.binod.admin.daoImpl.FineDaySettingDaoImpl;
import com.binod.admin.entity.FinePerDaySetting;
@WebServlet(name="fineday", urlPatterns="/fineday")
public class ShowFine extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FineDaySettingDao settingDao=new FineDaySettingDaoImpl();
		FinePerDaySetting daySetting=new FinePerDaySetting();
		daySetting=settingDao.getAlldays();
		req.setAttribute("day", daySetting);
		
		req.getRequestDispatcher("admin/setting/fineSetting.jsp").forward(req, resp);
	}

}
