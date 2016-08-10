package com.example;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

@RestController
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String readFromDB() throws Exception {
        String junk = "junk";

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        jdbcTemplate.execute("INSERT INTO ticks VALUES (now())");
        SqlRowSet srs = jdbcTemplate.queryForRowSet("SELECT tick FROM ticks");
        while (srs.next()) {
            junk = srs.getTimestamp("tick").toString();
            System.out.println("Read from DB: " + srs.getTimestamp("tick"));
        }

        return junk;
    }

    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
}
