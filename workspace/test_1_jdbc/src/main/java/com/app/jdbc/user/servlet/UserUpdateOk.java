package com.app.jdbc.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.user.dao.UserDAO;
import com.app.jdbc.user.vo.UserVO;

public class UserUpdateOk extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Long id = Long.valueOf(req.getParameter("id"));
		String userName = req.getParameter("userName"); 
		String userEmail = req.getParameter("userEmail"); 
		String userNickname = req.getParameter("userNickname"); 
		String userPhone = req.getParameter("userPhone"); 
		String userSportKind = req.getParameter("userSportKind"); 
		String userBirth = req.getParameter("userBirth"); 
		
		UserVO userVO = new UserVO();
		UserDAO userDAO = new UserDAO();
		
		userVO.setId(id);
		userVO.setUserName(userName);
		userVO.setUserEmail(userEmail);
		userVO.setUserNickname(userNickname);
		userVO.setUserPhone(userPhone);
		userVO.setUserSportKind(userSportKind);
		userVO.setUserBirth(userBirth);
		
		userDAO.update(userVO);
		resp.sendRedirect(req.getContextPath() + "/list");
	}
}
