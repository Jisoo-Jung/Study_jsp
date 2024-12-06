package com.app.jdbc.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.user.dao.UserDAO;
import com.app.jdbc.user.vo.UserVO;

public class UserWriteOk extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		사용자가 화면에서 작성한 정보 가져오기
//		DAO를 통해서 DB에 INSERT하기
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("userName"); 
		String userEmail = req.getParameter("userEmail"); 
		String userNickname = req.getParameter("userNickname"); 
		String userPhone = req.getParameter("userPhone"); 
		String userSportKind = req.getParameter("userSportKind"); 
		String userBirth = req.getParameter("userBirth"); 
		UserVO userVO = new UserVO();
		UserDAO userDAO = new UserDAO();
		
		userVO.setUserName(userName);
		userVO.setUserEmail(userEmail);
		userVO.setUserNickname(userNickname);
		userVO.setUserPhone(userPhone);
		userVO.setUserSportKind(userSportKind);
		userVO.setUserBirth(userBirth);
		
		userDAO.insert(userVO);
		
		//목록으로 이동하기
		resp.sendRedirect(req.getContextPath() + "/list");
		
	}

}
