package com.app.jdbc.guest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.guest.dao.GuestDAO;
import com.app.jdbc.guest.vo.GuestVO;

public class GuestUpdateOk extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Long id = Long.valueOf(req.getParameter("id"));
		String guestName = req.getParameter("guestName");
		String guestBirth = req.getParameter("guestBirth");
		
		GuestDAO guestDAO = new GuestDAO();
		GuestVO guestVO = new GuestVO();
		
		guestVO.setId(id);
		guestVO.setGuestName(guestName);
		guestVO.setGuestBirth(guestBirth);
		
		guestDAO.update(guestVO);
//		resp.sendRedirect(req.getContextPath() + "/read?id=" + id);
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}











