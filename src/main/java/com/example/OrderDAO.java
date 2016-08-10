package com.example;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Order order) {
        entityManager.persist(order);
        return;
    }

    @SuppressWarnings("unchecked")
    public List getAll() {
        String hql = "from Order";
        return entityManager.createQuery(hql).getResultList();
    }
}
