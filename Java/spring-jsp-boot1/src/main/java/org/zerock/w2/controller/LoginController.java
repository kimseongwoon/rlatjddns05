package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;

import org.zerock.w2.dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.zerock.w2.service.MemberService;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {

    /**
     * 로그인 페이지로 이동
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("login get.............");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    /**
     * 실제 로그인 기능 실행
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post........");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        
        String auto = req.getParameter("auto");
        boolean rememberMe = (auto != null && auto.equals("on"));

        //String str = mid + mpw;
        try {
        	MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
        	
        	if(rememberMe) { // 자동 로그인 체크박스가 체크되어 있을 경우
        		String uuid = UUID.randomUUID().toString();
        		
        		MemberService.INSTANCE.updateUuid(mid, uuid);
        		memberDTO.setUuid(uuid);
        		
        		// 쿠키에 rememberMe값을 저장
        		 Cookie rememberCookie =
                         new Cookie("remember-me", uuid);
                 rememberCookie.setMaxAge(60*60*24*7);  //쿠키의 유효기간은 1주일
                 rememberCookie.setPath("/");

                 resp.addCookie(rememberCookie);
        	}
        	
	        HttpSession session = req.getSession();
	        // 세션 저장소에 키가 loginInfo이고 값이 member값을 저장
	        session.setAttribute("loginInfo", memberDTO);
	
	        resp.sendRedirect("/spring-jsp-boot1/todo/list");    
		} catch(Exception e) {
	    	resp.sendRedirect("/spring-jsp-boot1/login?result=error");
	    }
    }
}
