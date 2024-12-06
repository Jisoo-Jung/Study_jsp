package com.app.jdbc.guest.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.guest.dao.GuestDAO;
import com.app.jdbc.guest.vo.GuestVO;

public class GuestList extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GuestDAO guestDAO = new GuestDAO();
		List<GuestVO> guests = guestDAO.selectAll();
		
		req.setAttribute("guests", guests);
		req.getRequestDispatcher("guest.jsp").forward(req, resp);
	}
}






