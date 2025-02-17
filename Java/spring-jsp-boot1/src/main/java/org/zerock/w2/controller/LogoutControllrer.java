package org.zerock.w2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j2;

@WebServlet("/logout")
@Log4j2
public class LogoutControllrer extends HttpServlet { 
	/**
     * 실제 로그인 기능 실행
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("logout post........");
        
        // 로그아웃은 세션 로그인 키인 loginInfo값을 삭제하는 것
        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo");
        session.invalidate();  // 로그아웃 완전처리를 위한 메소드
        
        resp.sendRedirect("/spring-jsp-boot1/login"); // 로그인 페이지로 이동
    }
}
