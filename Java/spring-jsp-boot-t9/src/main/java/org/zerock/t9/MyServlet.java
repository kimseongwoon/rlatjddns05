package org.zerock.t9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * my로 패턴이 되어 있는 url매핑은 아래 코드를 실행
 */
@WebServlet(name = "mySerlvet", urlPatterns = "/my")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
    		throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8;");
        
        PrintWriter out = resp.getWriter();
        out.println("<html lang='ko'><body><meta charset='utf-8'>");
        out.println("<h1>MyServlet9 한글9</h1>");
        out.println("</body></html>");
    }
}
