package com.example;

import java.util.List;

public interface TestDAO {
    public String retrieveWISEOrder(String conum, String orderNum, int orderSuffix);
    List<String> retrieveWISEOrdersBetweenDates(String conum, int shipDateStart, int shipDateEnd, int numRecords);
}
