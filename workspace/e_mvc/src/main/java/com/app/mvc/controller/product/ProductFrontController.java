package com.app.mvc.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.mvc.Result;

// .product로 끝나는 모든 요청을 처리해주는 FrontController
public class ProductFrontController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		//먼저 uri를 받아온다.
		//프로토콜,아이피,포트번호는 제외한 경로가 uri
		
		
		//먼저 사용자가 요청한 것이 뭔지에 따라서 구분을 해줘야하기에, 사용자가 요청한 경로를 알아내야 한다. 
//		/a/news
//		/a/games
//		이 통채로를 RequestURI()로 가져올 수 있다. 이 전체 중에 앞에 것은 필요없기에 뒤에 것만 잘라온다.
//		앞의 것은 놀랍게도 contextPath이다. 루트경로.
//		substring -> 문자열 자를 때 사용하는 메소드
//		substring(시작인덱스, 끝인덱스) -> 이렇게 잘라서 사용
		
		//uri를 받아온다. 프로토콜,  
		Result result = null;
		String target = uri.substring(req.getContextPath().length());
		//uri에서 substring을 써서 request에 있는 getContextPath의 길이만큼만 잘라주면 우리가 원하는 딱 뒤에 있는 경로를 가져올 수 있게 된다.
		//근데 /update로 끝나는 것이 있지만, /update/ok까지 써야하는 것도 있다. 그러니깐 마지막 것만 끊어버리면 안된다.
		//그러니깐 마지막 /를 기준으로 끊는 것이 아니라 앞에 있는 반드시 root경로 부터 시작을 해야 한다. 
		//그래서 시작 인덱스를 전달한 것이다.
		
		//substring(시작인덱스, 끝인덱스) //잘라서 사용하는 것
		target = target.split("\\.")[0];
		
//		DB에 접근하는 로직만 Controller로 관리한다.
		if(target.equals("/write")) {
			result = new Result();
			result.setPath("write.jsp");
		}else if(target.equals("/write/ok")) {
			result = new WriteOkController().execute(req, resp);
		}else if(target.equals("/list")) {
			result = new ListController().execute(req, resp);
		}
		
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(req.getContextPath() + result.getPath());
			}else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
		
	}
}
















