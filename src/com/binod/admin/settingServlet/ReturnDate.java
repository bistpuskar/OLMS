package com.binod.admin.settingServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.binod.admin.dao.ReturnDateSettingDao;
import com.binod.admin.daoImpl.ReturnDateSettingDaoImpl;
import com.binod.admin.entity.ReturnDateSetting;
@WebServlet(name="showdate",urlPatterns="/showdates")
public class ReturnDate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ReturnDateSettingDao dateSettingDao=new ReturnDateSettingDaoImpl();
		ReturnDateSetting dateSetting=dateSettingDao.getDate();
		req.setAttribute("days", dateSetting);
		req.getRequestDispatcher("admin/setting/returnDateSetting.jsp").forward(req, resp);
	}

}
