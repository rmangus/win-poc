package com.example;

import org.springframework.data.repository.CrudRepository;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Integer> {
}
