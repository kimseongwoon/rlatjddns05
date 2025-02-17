package org.zerock.t9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 브라우저에서 /hello-servlet이라는 url로 시작을 하면 해당 자바 코드가 실행
 */
@WebServlet(value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

	private String message;
	
	public void init() {
		this.message = "Hello World! - tomcat9";
	}
	
	// 브라우저에서 Get메소드로 호출된다면(브라우저 URL로 접근) 아래 메소드가 실행
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		response.setContentType("text/html");
		
		// Hello
		PrintWriter out = response.getWriter();
		//out.println("<html><body>Hello1</body></html>");
		out.println("<html><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("<h1>" + message + "</h1>");
		out.println("<h1>" + message + "</h1>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
	}
	
	public void destroy() {
		
	}
}
