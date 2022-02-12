package com.dzejju.ordering_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingAppApplication.class, args);
      //  ApplicationContext app = SpringApplication.run(OrderingAppApplication.class, args);//init the context
       // FillDatabase myBean = app.getBean(FillDatabase.class);//get the bean by type
    }


}
