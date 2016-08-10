package com.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class OrderDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Order order) {
        entityManager.persist(order);
        return;
    }

}
