package org.zerock.t9.todo;

import org.zerock.t9.todo.dto.TodoDTO;
import org.zerock.t9.todo.service.TodoService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Todo 리스트관련
 */
@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet{
	private TodoService todoService = TodoService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("/todo/list");
		
//		// TodoService클래스를 연결. 임의로 만든 Todo 10개 객체가 dtoList변수로 저장
//		List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
//		// View에 전달하기 위해 dtoList객체를 'list'라는 이름으로 저장
//		req.setAttribute("list", dtoList);
//		// /WEB-INF/todo/list.jsp파일로 이동
//		req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
		
		try {
			List<TodoDTO> dtoList = todoService.listAll();
			req.setAttribute("dtoList", dtoList);
			req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req,resp);
		} catch (Exception e) {
//			log.error(e.getMessage());
			throw new ServletException("list error");
		}
	}
}
