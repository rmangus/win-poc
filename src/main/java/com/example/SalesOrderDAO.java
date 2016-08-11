package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SalesOrderDAO {
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    public void setSalesOrderRepository(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }


    public void create(SalesOrder salesOrder) {
        salesOrderRepository.save(salesOrder);
        return;
    }

    @SuppressWarnings("unchecked")
    public Iterable<SalesOrder> getAll() {
        String hql = "from SalesOrder";
        return salesOrderRepository.findAll();
    }
}
