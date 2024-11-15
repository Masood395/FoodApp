package com.tap.orderhistorydao;

import java.util.List;

import com.tap.orderhistory.OrderHistory;

public interface OrderHistoryDAO {
    void addOrderHistory(OrderHistory orderHistory);
    OrderHistory getOrderHistory(int orderHistoryId);
    List<OrderHistory> getAllOrderHistories();
    void updateOrderHistory(OrderHistory orderHistory);
    void deleteOrderHistory(int orderHistoryId);
}
