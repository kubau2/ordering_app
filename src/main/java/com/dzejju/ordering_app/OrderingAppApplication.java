package com.dzejju.ordering_app;

import com.dzejju.ordering_app.database.Cart;
import com.dzejju.ordering_app.database.Stock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class OrderingAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderingAppApplication.class, args);
      //  ApplicationContext app = SpringApplication.run(OrderingAppApplication.class, args);//init the context
       // FillDatabase myBean = app.getBean(FillDatabase.class);//get the bean by type
    }


}
