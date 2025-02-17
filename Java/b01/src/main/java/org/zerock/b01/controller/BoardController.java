package org.zerock.b01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.b01.dto.BoardDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;
import org.zerock.b01.service.BoardService;

import javax.validation.Valid;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO pageResponseDTO
                = boardService.list(pageRequestDTO);
        log.info("responseDTO: " + pageResponseDTO);

        model.addAttribute("responseDTO",  pageResponseDTO);
    }

    @GetMapping("/register")
    public void registerGET() {
        // /board/register.html파일로 이동
    }
    @PostMapping("/register")
    public String registerPOST (
            @Valid BoardDTO boardDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        log.info("POST board register.......");
        log.info(boardDTO);

        // 만약에 todoDTO에서 설정한 validation이 통과되지 않은 경우
        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/board/register";
        }

        Long bno = boardService.register(boardDTO);
        // list.html에 보낼 등록 게시물의 번호 결과값을 전달
        redirectAttributes.addFlashAttribute("result", bno);

        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long bno, PageRequestDTO pageRequestDTO, Model model) {
        BoardDTO boardDTO = boardService.readOne(bno);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(
            PageRequestDTO pageRequestDTO,   // 페이지 네비게이션 처리를 위한 변수
            @Valid BoardDTO boardDTO,       // 실제 게시판 수정을 위한 변수
            BindingResult bindingResult,    // valid오류가 났을 때 처리하기 위한 변수
            RedirectAttributes redirectAttributes // 성공했을 경우 화면에 출력할 데이터 저장 변수
    ) {
        log.info("board modify post......." + boardDTO);

        // boardDTO의 validation처리에서 오류가 났을 경우
        if(bindingResult.hasErrors()) {
            log.info("has errors.......");

            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            redirectAttributes.addAttribute("bno", boardDTO.getBno());

            return "redirect:/board/modify?" + link;
        }
        boardService.modify(boardDTO);  // 실제 게시판 내용 수정

        // 모달창을 보이기 위한 속성
        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("bno", boardDTO.getBno());

        return "redirect:/board/read";  // 수정 성공 후 게시판 상세조회 페이지로 이동
    }

    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes rttr) {
        boardService.remove(bno);   // 실제 게시물 번호 삭제

        // 모달창을 보이기 위한 속성
        rttr.addFlashAttribute("result", "removed");

        return "redirect:/board/list";  // 삭제 이후 page번호 1번으로 이동;
    }
}
