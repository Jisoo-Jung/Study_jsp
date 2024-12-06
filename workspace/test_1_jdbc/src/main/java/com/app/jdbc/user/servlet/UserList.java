package com.app.jdbc.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.user.dao.UserDAO;
import com.app.jdbc.user.vo.UserVO;

public class UserList extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		List<UserVO> users = userDAO.selectAll();
		
		req.setAttribute("users", users);
		req.getRequestDispatcher("user.jsp").forward(req, resp);
		
	}
}
