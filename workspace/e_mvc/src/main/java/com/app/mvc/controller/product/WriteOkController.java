package com.app.mvc.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mvc.Action;
import com.app.mvc.Result;
import com.app.mvc.domain.ProductVO;
import com.app.mvc.repository.ProductDAO;

public class WriteOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Result result = new Result();
		ProductDAO productDAO = new ProductDAO();
		ProductVO productVO = new ProductVO();
		productVO.setProductName(req.getParameter("productName"));
		productVO.setProductPrice(Integer.valueOf(req.getParameter("productPrice")));
		productDAO.insert(productVO);
		
		result.setPath("/list.product");
		result.setRedirect(true);
		return result;
	}
}















