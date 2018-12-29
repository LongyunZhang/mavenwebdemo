package com.longyun.activemq;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;


public class MessageReceiverBTest {

    @Test
    public void receiverA() throws Exception {
        new ClassPathXmlApplicationContext("spring-receiver.xml");

        TimeUnit.DAYS.sleep(Integer.MAX_VALUE);
    }
}
