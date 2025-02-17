package org.zerock.springex.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller  // Spring Web MVC 컨트롤러로 설정
@Log4j2
@RequestMapping("/todo")   // 해당 클래스 컨트롤러는 항상 url앞에 /todo로 시작하는 것들로 설정
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService todoService;
	
	// 해당 메소드는 /todo/list로 접근을 했을 때 동작하는 메소드
	//@RequestMapping("/list")  
	public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
		log.info("todo list.......");
		log.info("pageRequestDTO: " + pageRequestDTO);

		// valid에러가 날 경우 처리
		if(bindingResult.hasErrors()) {
			// 기본값이 page 1, size 10인 객체가 생성
			pageRequestDTO = PageRequestDTO.builder().build();
		}
	
		// deprecate
		//model.addAttribute("dtoList", todoService.getAll());
		model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
	}
	
	// 해당 메소드는 /todo/register로 접근을 했을 때 동작하는 메소드
	//@RequestMapping(value = "/register", method = RequestMethod.GET)
	//@RequestMapping("/register")  // GET 메소드
	@GetMapping("/register")      // GET 메소드
	public void registerGET() {
		log.info("GET todo register.......");
	}
	
	@PostMapping("/register")  // POST 메소드
	public String registerPOST(
		@Valid TodoDTO todoDTO,
		BindingResult bindingResult,
		RedirectAttributes rttr
	) {
		log.info("POST todo register.......");
		log.info(todoDTO);
		
		// 만약에 todoDTO에서 설정한 validation이 통과되지 않은 경우
		if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            rttr.addFlashAttribute("errors", bindingResult.getAllErrors());
            
            return "redirect:/todo/register";
        }		
		todoService.register(todoDTO);
		
		return "redirect:/todo/list";
	}
	
	// /todo/read로 접근을 하면 read.jsp로 이동
	// /todo/modify로 접근을 하면 modify.jsp로 이동
	@GetMapping({"/read", "/modify"})
	public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
		log.info("todo one.......");

		TodoDTO todoDTO = todoService.getOne(tno);
		log.info(todoDTO);

		model.addAttribute("dto", todoDTO);
	}
	
	@PostMapping("/remove")  // POST 메소드
	public String removePOST(
		Long tno,
		PageRequestDTO pageRequestDTO, // 페이징 이동 처리
		RedirectAttributes rttr
	) {
		log.info("todo remove one.......");
		
		// 실제 삭제
		todoService.remove(tno);
		// 페이징 이동 처리
		rttr.addAttribute("page", 1);	// 삭제 이후에는 항상 리스트 1페이지로 이동
		rttr.addAttribute("size", pageRequestDTO.getSize());
		
		return "redirect:/todo/list" + pageRequestDTO.getLink();
	}
	
	@PostMapping("/modify")
    public String modify(
        @Valid TodoDTO todoDTO,
        PageRequestDTO pageRequestDTO,  // 페이징 이동 처리
        BindingResult bindingResult, 
        RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            redirectAttributes.addAttribute("tno", todoDTO.getTno() );
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);

        todoService.modify(todoDTO);
        
        redirectAttributes.addAttribute("tno", todoDTO.getTno());
        // 페이징 이동 처리 
//        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
//        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        return "redirect:/todo/read";
    }
}
