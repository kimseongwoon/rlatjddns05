package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * Todo 리스트 조회관련
 */
//@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;  // TodoService 객체 연결

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //log.info("todo list..................");

        HttpSession httpSession = req.getSession();

        ServletContext sc = req.getServletContext();
        log.info("appName: " + sc.getAttribute("appName"));
        
        try {
            // todoService 객체에서 조회리스트를 불러옴
            List<TodoDTO> dtoList = todoService.listAll();

            // View(list.jsp)에 전달할 객체를 attribute에 저장
            req.setAttribute("dtoList", dtoList);
            req.setAttribute("test1", "abcd");
            
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req,resp);
        } catch(Exception e) {
            throw new ServletException("list error");
        }
    }
}
