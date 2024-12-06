package com.app.jdbc.guest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.guest.dao.GuestDAO;
import com.app.jdbc.guest.vo.GuestVO;

public class GuestRead extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GuestDAO guestDAO = new GuestDAO();
		String input = req.getParameter("id");
		Long id = Long.valueOf(input);
		GuestVO guestVO = guestDAO.selectById(id);
		req.setAttribute("guest", guestVO);
		req.getRequestDispatcher("/read.jsp").forward(req, resp);
	}
}










