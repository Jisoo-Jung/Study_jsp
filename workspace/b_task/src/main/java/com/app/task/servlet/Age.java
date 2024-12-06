package com.app.task.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Age extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int age = Integer.parseInt(req.getParameter("age"));
		age--;
		req.setAttribute("age", age);
		req.getRequestDispatcher("age.jsp").forward(req, resp);
	}
}










