package com.app.jdbc.guest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbc.guest.dao.GuestDAO;
import com.app.jdbc.guest.vo.GuestVO;

public class GuestWriteOk extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		사용자가 화면에서 작성한 정보 가져오기
//		DAO를 통해서 DB에 INSERT하기
		req.setCharacterEncoding("UTF-8");
		String guestName = req.getParameter("guestName");
		String guestBirth = req.getParameter("guestBirth");
		GuestVO guestVO = new GuestVO();
		GuestDAO guestDAO = new GuestDAO();
		
		guestVO.setGuestName(guestName);
		guestVO.setGuestBirth(guestBirth);
		
		guestDAO.insert(guestVO);
		
//		목록으로 이동하기
		resp.sendRedirect(req.getContextPath() + "/list");
	}
}

















