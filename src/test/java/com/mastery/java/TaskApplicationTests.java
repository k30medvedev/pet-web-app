package com.mastery.java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskApplicationTests extends Postgres {

    @Override
    public void startSqlConteiner() {
        super.startSqlConteiner();
    }

    @Test
    void contextLoads() {
    }
}
