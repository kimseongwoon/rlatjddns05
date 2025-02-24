package org.zerock.b01.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.b01.dto.ReplyDTO;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/replies")
public class ReplyController {
    @ApiOperation(value = "댓글 등록", notes = "POST로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> register(
            // @RequestBody는 replayDTO를 json으로 보낼 때 받기 위한 어노테이션
            @Valid @RequestBody ReplyDTO replyDTO,
             BindingResult bindResult
    )  throws BindException {
        log.info("register replyDTO: " + replyDTO);

        if(bindResult.hasErrors()) {
            throw new BindException(bindResult); // @RestControllerAdvice에서 exception처리 설정한 곳으로 이동
        }

        //Map<String, Long> resultMap = Map.of("rno", 111L);
        //resultMap.put("test1", 1L);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", 111L);
        resultMap.put("test1", 1L);

        return ResponseEntity.ok(resultMap); // http code 200번
    }
}
