package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

@Controller
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "testing automation for review apps AND auto-deploy to prod";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}