package com.example.amqp;

import com.example.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    //点对点
    @Test
    public void contextLoads() {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("msg","这是第一个消息！");
        map.put("data", Arrays.asList("helloworld",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
    }


    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));
    }

    @Autowired
    AmqpAdmin amqpAdmin;

    //管理组件AmqpAdmin的使用
    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        System.out.println("创建完成");
    }
}
