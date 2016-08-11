package com.example;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Hashtable;

@RestController
public class SalesOrderController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(path = "/", produces = "application/json")
    public Hashtable<Integer, String> readFromDB() throws Exception {
        Hashtable<Integer, String> junk = new Hashtable<Integer, String>();

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ticks (id SERIAL PRIMARY KEY, tick timestamp)");
        jdbcTemplate.execute("INSERT INTO ticks (tick) VALUES (now())");
        SqlRowSet srs = jdbcTemplate.queryForRowSet("SELECT id, tick FROM ticks");
        while (srs.next()) {
            junk.put(srs.getInt("id"), srs.getTimestamp("tick").toString());
            System.out.println("Read from DB: " + srs.getInt("id") + " : " + srs.getTimestamp("tick"));
        }

        return junk;
    }

    @RequestMapping(path = "/orders/create/{orderNum}", produces = "application/json")
    public SalesOrder createOrder(@PathVariable String orderNum) throws Exception {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.orderNum = orderNum;
        salesOrder.orderDate = new Date();
        salesOrderDAO.create(salesOrder);
        return salesOrder;
    }

    @RequestMapping(path = "/orders", produces = "application/json")
    public Iterable<SalesOrder> getOrders() throws Exception {
        return salesOrderDAO.getAll();
    }

    @Autowired
    private SalesOrderDAO salesOrderDAO;
}