package org.zerock.springex.controller.exception;

import java.util.Arrays;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice  // 예외처리를 세팅하기 위해서 사용하는 설정. Bean에 자동으로 등록
@Log4j2
public class CommonExceptionAdvice {
	
	@ResponseBody
	@ExceptionHandler(NumberFormatException.class) // NumberFormatException발생했을 때 아래 메소드를 실행
	public String exceptNumber(NumberFormatException nfe) {
		log.error("NumberFormatException: ------------------------------");
		log.error(nfe.getMessage());
		
		//return "exception1";
		return "NUMBER FORMAT EXCEPTION";
	}
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String exceptCommon(Exception exception) {
		log.error("Exception: -----------------------------------");
        log.error(exception.getMessage());

        StringBuffer buffer = new StringBuffer("<ul>");

        buffer.append("<li>" +exception.getMessage()+"</li>");

        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement+"</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
	}
	
	// 페이지가 없는 404 코드일 경우 실행
	@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(){
        return "custom404";	// /WEB-INF/views/custom404.jsp로 이동
    }

}
