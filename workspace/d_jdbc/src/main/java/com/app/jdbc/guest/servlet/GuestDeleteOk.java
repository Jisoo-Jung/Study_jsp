package com.app.jdbc.guest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.guest.dao.GuestDAO;

public class GuestDeleteOk extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		GuestDAO guestDAO = new GuestDAO();
		
		guestDAO.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}
