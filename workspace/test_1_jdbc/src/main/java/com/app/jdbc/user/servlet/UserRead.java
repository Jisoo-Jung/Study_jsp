package com.app.jdbc.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.user.dao.UserDAO;
import com.app.jdbc.user.vo.UserVO;

public class UserRead extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		String input = req.getParameter("id");
		Long id = Long.valueOf(input);
		UserVO userVO = userDAO.selectById(id);
		req.setAttribute("user", userVO);
		req.getRequestDispatcher("/read.jsp").forward(req, resp);
	}
	
}
