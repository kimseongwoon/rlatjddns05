package org.zerock.springex.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.sample.SampleService;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {
	// DI(의존성 주입) 기능을 사용
    @Autowired    // ApplicationContext안에 new SampleService()한 객체가 있고 그것을 sampleService라는 변수에 대입한 것과 같다.
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService1() {
        log.info("sampleService: " + sampleService);
        Assertions.assertNotNull(sampleService);

        sampleService.test1();
    }

    @Test
    public void testConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);

        connection.close();
    }
}
