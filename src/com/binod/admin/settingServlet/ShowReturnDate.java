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

@WebServlet(name = "returndate", urlPatterns = "/returndate")
public class ShowReturnDate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReturnDateSettingDao returnDateSettingDao = new ReturnDateSettingDaoImpl();
		ReturnDateSetting returnDateSetting = new ReturnDateSetting();
		returnDateSettingDao.updateDate(Integer.parseInt(req.getParameter("bookduration")));
		returnDateSetting=returnDateSettingDao.getDate();
		req.setAttribute("days", returnDateSetting);
		req.getRequestDispatcher("admin/setting/returnDateSetting.jsp").forward(req, resp);
		
		

	}

}
