package org.zerock.w2.filter;

import javax.servlet.*;
import java.io.*;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zerock.w2.service.MemberService;

import lombok.extern.log4j.Log4j2;

import org.zerock.w2.dto.*;

//url이 '/todo/'로 시작하는 것은 아래 doFilter메소드를 항상 실행(ex) /todo/list, /todo/register, /todo/modify....)
//@WebFilter(urlPatterns = {"/todo/*"} )
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        log.info("Login check filter...");
        //System.out.println("Login check filter...");

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpSession session = req.getSession();

        // 로그인을 했는지 안했는지 체크하는 로직
        if(session.getAttribute("loginInfo") == null) {  // 로그인을 안 했을 경우
        	chain.doFilter(request, response);
        	return;
        }
        
        // 2. 만약 로그인을 하지 않았으면 자동 로그인 쿠키를 체크
        Cookie cookie = findCookie(req.getCookies(), "remember-me");
        if (cookie == null) {  // 쿠키가 없으면 다시 로그인 페이지로 이동.
        	resp.sendRedirect("/spring-jsp-boot1/login");
        	return;
        }
        log.info("브라우저에 자동로그인 쿠키가 존재");
        
        // 쿠키가 있다면 자동 로그인을 실행
		try {
			// 자동 로그인을 실행할 수 있는 사용자 정보를 uuid를 통해서 가져옴
			String uuid = cookie.getValue();  // uuid값
			// uuid를 통해서 DB에서 확인
			MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);
			log.info("remember-me 쿠키값으로 조회한 사용자 정보: " + memberDTO);
			
			if (memberDTO == null) { // uuid값으로 조회해서 사용자 정보가 없다면
				throw new Exception("유효하지 않은 remember-me 쿠키값");
			}
			// 만약 uuid값으로 조회한 사용자 정보가 있다면 사용자 정보를 세션에 저장
			session.setAttribute("loginInfo", memberDTO);
		} catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/spring-jsp-boot1/login");
		}
        
		chain.doFilter(request, response);
	}
	
	// 브라우저에서부터 cookieName값이 있는지 체크하여 Cookie값을 조회
	private Cookie findCookie(Cookie[] cookies, String cookieName) {
//    	Cookie targetCookie = null;
//    	
//    	// 기존 브라우저에서 쿠키공간에 cookieName과 같은 이름을 가진 쿠키값이 있는지 체크하여 쿠키 리턴
//    	if(cookies != null && cookies.length > 0) {
//    		for(Cookie ck : cookies) {
//    			if(ck.getName().equals(cookieName)) {
//    				targetCookie = ck;
//    				break;
//    			}
//    		}
//    	}
//    	
//    	return targetCookie;
		
		if(cookies == null || cookies.length == 0){
            return null;
        }
        Optional<Cookie> result 
        	= Arrays.stream(cookies).filter(ck -> 
        		ck.getName().equals(cookieName))
        			.findFirst();
        
        return result.isPresent() ? result.get() : null;
    }
}
