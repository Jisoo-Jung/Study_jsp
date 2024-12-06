package com.app.jdbc.matching.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.matching.dao.MatchingDAO;
import com.app.jdbc.matching.vo.MatchingVO;

public class MatchingRead extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MatchingDAO matchingDAO = new MatchingDAO();
		Long id = Long.valueOf(req.getParameter("id"));
		MatchingVO matchingVO = matchingDAO.selectById(id);
		req.setAttribute("matching", matchingVO);
		req.getRequestDispatcher("/read.jsp").forward(req, resp);
	}
}
