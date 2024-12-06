package com.app.jdbc.place.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.place.dao.PlaceDAO;
import com.app.jdbc.place.vo.PlaceVO;

public class PlaceList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PlaceDAO placeDAO = new PlaceDAO();
		List<PlaceVO> places = placeDAO.selectAll();
		
		req.setAttribute("places", places);
		req.getRequestDispatcher("place.jsp").forward(req, resp);
	}
}
