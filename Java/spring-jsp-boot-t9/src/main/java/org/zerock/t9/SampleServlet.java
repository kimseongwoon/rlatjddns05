package org.zerock.t9;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("doGet..." + this);
		
		// HttpServletRequest 살펴보기
		Enumeration<String> reqHeaderNames = req.getHeaderNames();
		
		while(reqHeaderNames.hasMoreElements()) {
			String headerElementName = reqHeaderNames.nextElement();
			System.out.println("request header name: " + headerElementName);   // HTTP 헤더 이름들 출력
			System.out.println("request header value: " + req.getHeader(headerElementName));
		}
		//System.out.println(req.getHeader(""));
		System.out.println(req.getRemoteAddr());	// 접속한 사용자의 IP주소
		System.out.println(req.getMethod());		// GET or POST등 사용자 호출 URL메소드
		System.out.println(req.getRequestURL());	// 요청 URL
		System.out.println(req.getCookies());	    // 브라우저가 전송한 쿠키 정보
		
		// HttpServletResponse 살펴보기
		System.out.println(resp.getWriter());	    // 응답 메시지 출력 객체 값 가져오기
		Enumeration<String> respHeaderNames = req.getHeaderNames();
		while(respHeaderNames.hasMoreElements()) {
			String headerElementName = respHeaderNames.nextElement();
			System.out.println("response header name: " + headerElementName);   // HTTP 헤더 이름들 출력
			System.out.println("response header value: " + req.getHeader(headerElementName));
		}
	}
	
	/**
	 * url경로가 /sample페이지를 나갔을 때 실행(사실 tomcat이 종료되었을 경우 or 재로딩할 때 실행) 
	 */
	@Override
	public void destroy() {
		System.out.println("destroy.............");
	}
	
	/**
	 * url경로가 /sample페이지로 접근했을 때 제일 처음에만 실행
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init(ServletConfig)...........");
	}
}
