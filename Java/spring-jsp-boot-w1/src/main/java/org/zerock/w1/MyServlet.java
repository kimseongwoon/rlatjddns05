package org.zerock.w1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        out.println("<html><body><meta charset='utf-8'>");
        out.println("<h1>MyServlet10 한글10</h1>");
        out.println("</body></html>");
    }
}
