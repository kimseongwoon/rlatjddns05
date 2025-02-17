package org.zerock.t9.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "indexTestController", urlPatterns = "/index")
public class IndexTestController extends HttpServlet {

	/**
	 * GET 요청으로 왔을 경우 실행
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("IndexTestController...doGet...");
		
		// view로 전달하기 위해 사용. doGet을 다 실행하고 데이터를 전달할 view jsp파일 지정
		RequestDispatcher dispatcher 
			= req.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(req, resp);
	}
}
