package com.longyun.activemq;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;



public class MessageSenderTest {


    @Test
    public void sender() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
//        JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-sender.xml");
        MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);
        for (int i = 0; i < 148; i++) {
            Map<String, Object> content = new HashMap<>();
            content.put("name", "caobug");
            content.put("age", i);
            content.put("will", "say hello");
            messageSender.sender(content);

            System.out.println("发送消息 = " + objectMapper.writeValueAsString(content));
            TimeUnit.SECONDS.sleep(1);
        }
    }

    // 1357, 2468,{10万结果} 张三
}
