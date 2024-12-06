package com.app.jdbc.matching.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.matching.dao.MatchingDAO;

public class MatchingDeleteOk extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		MatchingDAO matchingDAO = new MatchingDAO();
		
		matchingDAO.delete(id);
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}
}
