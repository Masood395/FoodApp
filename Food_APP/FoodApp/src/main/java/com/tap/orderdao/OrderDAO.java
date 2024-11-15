package com.tap.orderdao;

import java.util.List;
import com.tap.order.Order;

public interface OrderDAO {
    void addOrder(Order order);
    Order getOrder(int orderId);
    List<Order> getAllOrders();
    void updateOrder(Order order);
    void deleteOrder(int orderId);
}
