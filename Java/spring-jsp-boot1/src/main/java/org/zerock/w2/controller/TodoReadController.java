package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;

import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));

            // todo get서비스로 view에 전달할 dto객체 받기
            TodoDTO todoDTO = todoService.get(tno);

            // jsp view단에서 사용하기 위해서 attribute모델 담기
            req.setAttribute("dto", todoDTO);

            // 쿠키 찾기
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exist = false;		// 한번이라도 todo 상세조회를 한 것이 있는지 체크하는 변수
            
            if(todoListStr != null && todoListStr.indexOf(tno + "-") >= 0) {
            	exist = true;
            }
            
            if(!exist) { // exist가 false이면... 즉 tno + "-"로 된 값이 없다면 추가하고 있으면 skip
            	todoListStr += tno + "-";
            	
            	viewTodoCookie.setValue(todoListStr);
            	viewTodoCookie.setPath("/");
            	viewTodoCookie.setMaxAge(60*60*24);  // 쿠키값의 유효기간은 24시간동안 유지(단위는 초)
            	
            	resp.addCookie(viewTodoCookie);  // 요청한 브라우저의 쿠키공간에 저장
            }
            
            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        }catch(Exception e){
        	e.printStackTrace(); 
        	
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }
    
    private Cookie findCookie(Cookie[] cookies, String cookieName) {
    	Cookie targetCookie = null;
    	
    	// 기존 브라우저에서 쿠키공간에 cookieName과 같은 이름을 가진 쿠키값이 있는지 체크하여 쿠키 리턴
    	if(cookies != null && cookies.length > 0) {
    		for(Cookie ck : cookies) {
    			if(ck.getName().equals(cookieName)) {
    				targetCookie = ck;
    				break;
    			}
    		}
    	}
    	
    	// 기존 브라우저에서 쿠키공간에 cookieName과 같은 이름을 가진 쿠키값이 없다면 새로 cookieName값 이름으로 저장
    	if (targetCookie == null) {
    		targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24);  // 쿠키값의 유효기간은 24시간동안 유지(단위는 초)
    	}
    	
    	return targetCookie;
    }
}
