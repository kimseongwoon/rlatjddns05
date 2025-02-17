package org.zerock.springex.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@Controller  // Spring Web MVC에서 제공하는 어노테이션
@Log4j2
public class SampleController {

	@GetMapping("/hello")
	public void hello() {
		log.info("hello...........");
	}
	
	@GetMapping("/ex1")
	public void ex1(String name, int age) {
		log.info("ex1...........");
		log.info("name: " + name);
		log.info("age: " + age);
	}
	
	@GetMapping("/ex2")
	public void ex2(
		@RequestParam(name = "name_abc", defaultValue="AAA") String name,
		@RequestParam(name = "age", defaultValue="20") int age
	) {
		log.info("ex2...........");
		log.info("name: " + name);
		log.info("age: " + age);
	}
	
	@GetMapping("/ex3")
	public void ex3(String title, LocalDate dueDate) {
		log.info("ex3...........");
		log.info("dueDate: " + dueDate);
	}
	
	@GetMapping("/ex4")
	public void ex4(Model model) {
		log.info("------------------------------------");
		model.addAttribute("message", "Hello World"); // jsp에서 사용할 데이터를 저장
	}
	
	@GetMapping("/ex4_1")
	public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
		log.info("ex4_1-----------------------------");
		log.info(todoDTO);
	}
	
	@GetMapping("/ex5")
	public String ex5(RedirectAttributes redirectAttr) {
		redirectAttr.addAttribute("name", "ABC");
		redirectAttr.addFlashAttribute("result", "success");
		
		return "redirect:/ex6";
	}
	
	@GetMapping("/ex6")
	public void ex6() {
		
	}
	
	@GetMapping("/ex7")
	public void ex7(String p1, int p2) {
		//Integer.parseInt("aaa");
		
		log.info("p1........." + p1);
		log.info("p2........." + p2);
	}
}
