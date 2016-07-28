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
<<<<<<< HEAD
      return "branch POC-1!";
=======
      return "Hello production";
>>>>>>> 21200897bb2a24cfcf29a884f20c4ae083ca7d68
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}