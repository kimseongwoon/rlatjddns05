package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Todo 등록 관련
 */
//@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;  // TodoService 객체 연결

    /**
     * 할일 등록 페이지로 이동
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        log.info("/todo/register GET..................");

//      // 세션 객체 가져오기
//      HttpSession session = req.getSession();
//
//      // JSESSIONID가 없는 경우 새로운 사용자
//      if(session.isNew()) {
//          log.info("JSESSIONID 쿠키가 새로 만들어진 경우");
//
//          // 세션이 처음인 경우 로그인 페이지로 이동
//          resp.sendRedirect("/spring-jsp-boot1/login");
//          return;
//      }
//      // JSESSIONID가 있는 경우라도 세션 저장소(컨택스트)에 loginInfo라는 키가 없는 경우도 로그인 페이지로 이동
//      if(session.getAttribute("loginInfo") == null) {
//          log.info("로그인한 정보가 없는 사용자");
//
//          resp.sendRedirect("/spring-jsp-boot1/login");
//          return;
//      }

        // JSESSIONID가 있는 경우 register.jsp.jsp로 이동
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req,resp);
    }

    /**
     * 실제 할일을 등록
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //req.setCharacterEncoding("UTF-8");

        log.info("/todo/register.jsp POST..................");

        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))   // 화면에서 입력한 title값
                .dueDate(                             // 화면에서 입력한 dueDate값
                        LocalDate.parse(
                        req.getParameter("dueDate"),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                ).build();

        log.info(todoDTO);
        try {
            todoService.register(todoDTO);  // 실제 DB에 할일을 등록
        } catch(Exception e) {
            e.printStackTrace();
        }
        // 그 이후 할일 목록 페이지로 이동
        resp.sendRedirect("/spring-jsp-boot1/todo/list");
    }
}
