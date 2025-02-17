package org.zerock.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {
	
	@Autowired(required = false)  // required는 false로 지정을 하면 객체를 주입받지 못하더라도 예외가 발생하지 않도록 함
    private TimeMapper timeMapper;

	@Autowired
    private TimeMapper2 timeMapper2;

    @Test
    public void testGetTime() {
        log.info(timeMapper.getTime());
    }

    @Test
    public void testGetMname() {
        log.info(timeMapper.getMname());

        Assertions.assertEquals(timeMapper.getMname(), "사용자0");
    }
    
    @Test
    public void testNow() {
        log.info(timeMapper2.getNow());
    }

    @Test
    public void testGetMname2() {
        log.info(timeMapper2.getMname2());

        Assertions.assertEquals(timeMapper2.getMname2(), "사용자2");
    }
}
