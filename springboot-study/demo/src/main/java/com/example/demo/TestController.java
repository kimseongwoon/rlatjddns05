package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    //웹 브라우저에서 locallhost:8080/humanit를 접근했을 때 처리하는 함수
    @GetMapping("/humanit")    //콘텐츠 조회(1개) 0개의 사용위치
    public String test1() {
        return "test1";      // templates/test1.html 로 이동
    }

    @GetMapping("/test2.do")
    public String test2() {
        return "test2";      // templates/test2.html 로 이동
    }

    @GetMapping("/board-list")
    public String boardList(Model model) {
        model.addAttribute( "k3" , saveTitle);
        model.addAttribute( "k2" , "테스트임");
        return "board-list";
    }

    @GetMapping("/board-detail")
    public String boardDetail() {
        return "board-detail";
    }

    @GetMapping("/board-insert")
    public String boardInsert() {
        return "board-insert";
    }

    @GetMapping("/board-delete")
    public String boardDelete() {
        return "board-delete";
    }

    @GetMapping("/board-update")
    public String boardUpdate() {
        return "board-update";
    }

    @GetMapping("/board/1")
    public String boardOne() {
        return "board-detail";
    }

    @GetMapping("/board/2")
    public String boardTwo() {
        return "board-detail";
    }

    @GetMapping("/board/{id}")
    public String boardDatailPath(@PathVariable int id, Model model) {
        model.addAttribute("a" , id);
        return "board-detail";
    }


    private String saveTitle = "";     // 멤버함수
    private List<String> saveTitleList = new ArrayList<>();

    @PostMapping("/board/insert")   // 함수
    public String boardInsertDate(String title) {
        saveTitle = title;
        saveTitleList.add(title);
        return "redirect:/board-list";
    }
}
