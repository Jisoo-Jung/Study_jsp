package com.app.jdbc.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.user.dao.UserDAO;

public class UserUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		Long id = Long.valueOf(req.getParameter("id"));
		req.setAttribute("user", userDAO.selectById(id));
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
}
