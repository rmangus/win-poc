package com.example;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String orderNum;

    @Column(nullable = false)
    public Date orderDate;
}
