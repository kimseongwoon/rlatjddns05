package org.zerock.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository // SampleDAO라는 이름으로 Spring Bean으로 등록
@Qualifier("normal")
public class SampleDAOImpl  implements SampleDAO {
    @Override
    public void daoTest1() {
        System.out.println("SampleDAOImpl실행 - 잘 나오나?");
    }
}
