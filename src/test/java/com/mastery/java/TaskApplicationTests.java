package com.mastery.java;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskApplicationTests extends Postgres {

    @Override
    public void startSqlContainer() {
        super.startSqlContainer();
    }

    @Test
    void contextLoads() {
    }
}
