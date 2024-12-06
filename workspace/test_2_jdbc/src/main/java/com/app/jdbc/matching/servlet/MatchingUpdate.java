package com.app.jdbc.matching.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.matching.dao.MatchingDAO;

public class MatchingUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MatchingDAO matchingDAO = new MatchingDAO();
		Long id = Long.valueOf(req.getParameter("id"));
		req.setAttribute("matching", matchingDAO.selectById(id));
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
}
