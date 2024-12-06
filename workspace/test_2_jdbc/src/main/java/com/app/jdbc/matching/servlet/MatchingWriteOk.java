package com.app.jdbc.matching.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.matching.dao.MatchingDAO;
import com.app.jdbc.matching.vo.MatchingVO;

public class MatchingWriteOk extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		String matchingStatus = req.getParameter("matchingStatus");
		MatchingVO matchingVO = new MatchingVO();
		MatchingDAO matchingDAO = new MatchingDAO();
		
		matchingVO.setMatchingStatus(matchingStatus);
		
		matchingDAO.insert(matchingVO);
		
		resp.sendRedirect(req.getContextPath() + "/list");
	}
}
