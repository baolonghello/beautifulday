package com.eloancn.bt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@MapperScan(basePackages = "om.eloancn.process.dao", annotationClass = MyBatisRepository.class)--spring已配置，故删除
//@ComponentScan(basePackages = {"com.eloancn.process.dao"})
//@ImportResource(locations = {  "classpath:applicationContext.xml"})
public class BtApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(BtApplication.class, args);
    }

}
