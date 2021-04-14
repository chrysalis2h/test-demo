package com.cycle.rubbish.service;

import com.cycle.rubbish.api.TransactionalTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTestServiceImplTest {

    @Autowired
    private TransactionalTestService transactionalTestService;

    @Test
    public void insert1() {
        transactionalTestService.insert1();
    }

    @Test
    public void insert2() {
        transactionalTestService.insert2();
    }

}

