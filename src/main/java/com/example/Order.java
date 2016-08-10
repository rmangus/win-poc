package com.example;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    public Long id;

    @Column(nullable = false)
    public String orderNum;
}
