package org.zerock.t9.calc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {

	/**
	 * POST 요청으로 왔을 경우 실행
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		String txt1 = req.getParameter("txt1");
		String txt2 = req.getParameter("txt2");
		
		System.out.printf(" num1: %s", num1);
		System.out.printf(" num2: %s", num2);
		System.out.printf(" txt1: %s", txt1);
		System.out.printf(" txt2: %s", txt2);
		
		// url매핑이 /spring-jsp-boot-t9/index로 매핑된 java servlet코드를 실행(get으로 요청)
		resp.sendRedirect("/spring-jsp-boot-t9/index");
		//resp.sendRedirect("/spring-jsp-boot-t9/index.jsp");
		//resp.sendRedirect("/spring-jsp-boot-t9/test.jsp");
	}
}
