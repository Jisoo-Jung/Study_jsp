package com.app.mvc.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mvc.Action;
import com.app.mvc.Result;
import com.app.mvc.repository.ProductDAO;

public class ListController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		Result result = new Result();
		
		req.setAttribute("products", productDAO.selectAll());
		
		result.setPath("list.jsp");
		return result;
	}

}
