package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.*;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;

@Controller
@SpringBootApplication
public class DemoApplication {

	@Autowired
    private DataSource dataSource;
    
    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "welp";
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}