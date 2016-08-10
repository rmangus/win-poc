package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;

@Controller
@SpringBootApplication
@PropertySource({"classpath:application.properties"})
public class DemoApplication {
    @Autowired
    private DataSource dataSource;

    @RequestMapping("/")
    @ResponseBody
    String home() throws SQLException {
        myRealMainMethod();
        return "more testing";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void myRealMainMethod() throws SQLException {
        try {
            Statement stmt = dataSource.getConnection().createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
            stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
            stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
            ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
            while (rs.next()) {
                System.out.println("Read from DB: " + rs.getTimestamp("tick"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}