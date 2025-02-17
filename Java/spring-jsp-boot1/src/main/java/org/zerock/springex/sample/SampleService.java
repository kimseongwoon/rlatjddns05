package org.zerock.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service  // SampleService라는 이름으로 Spring Bean에 등록
@ToString
@RequiredArgsConstructor
public class SampleService {
	//@Autowired
    @Qualifier("normal")
    private final SampleDAO sampleDAO;

    public void test1() {
        sampleDAO.daoTest1();
    }
}
