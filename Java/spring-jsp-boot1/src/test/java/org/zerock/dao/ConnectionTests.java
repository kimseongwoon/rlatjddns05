package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectionTests {

    // 테스트코드로서 메소드 단위로 단독적인 실행이 가능
    @Test
    public void test1() {
        int v1 = 100;
        int v2 = 100;

        // v1의 값과 v2의 값이 같으면 Test통과
        Assertions.assertEquals(v1, v2);
    }
}
