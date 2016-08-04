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
      //return "more testing 08/04/2016";
    	String what = myRealMainMethod();
    	return what;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public String myRealMainMethod() {
    	String returnStuff = "";
    	
    	try {
	        Statement stmt = dataSource.getConnection().createStatement();
	        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
	        stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
	        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
	        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
	        while (rs.next()) {
	            returnStuff = "Read from DB: " + rs.getTimestamp("tick");
	        }
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}

        return returnStuff;    	
    }    
}