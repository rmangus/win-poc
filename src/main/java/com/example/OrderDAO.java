package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderDAO {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public void create(Order order) {
        orderRepository.save(order);
        return;
    }

    @SuppressWarnings("unchecked")
    public Iterable<Order> getAll() {
        String hql = "from Order";
        return orderRepository.findAll();
    }
}
