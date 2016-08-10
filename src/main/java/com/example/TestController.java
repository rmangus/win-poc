package com.example;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Hashtable;

@RestController
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/", produces = "application/json")
    public Hashtable<Integer, String> readFromDB() throws Exception {
        Hashtable<Integer, String> junk = new Hashtable<Integer, String>();

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ticks (id SERIAL PRIMARY KEY, tick timestamp)");
        jdbcTemplate.execute("INSERT INTO ticks VALUES (now())");
        SqlRowSet srs = jdbcTemplate.queryForRowSet("SELECT id, tick FROM ticks");
        while (srs.next()) {
            junk.put(srs.getInt("id"), srs.getTimestamp("tick").toString());
            System.out.println("Read from DB: " + srs.getInt("id") + " : " + srs.getTimestamp("tick"));
        }

        return junk;
    }
}
