package com.app.jdbc.matching.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.matching.dao.MatchingDAO;
import com.app.jdbc.matching.vo.MatchingVO;

public class MatchingList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MatchingDAO matchingDAO = new MatchingDAO();
		List<MatchingVO> matchings =matchingDAO.selectAll();
		
		req.setAttribute("matchings", matchings);
		req.getRequestDispatcher("matching.jsp").forward(req, resp);
	}
}
