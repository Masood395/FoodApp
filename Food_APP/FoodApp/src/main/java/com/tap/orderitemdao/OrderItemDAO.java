package com.tap.orderitemdao;

import java.util.List;

import com.tap.orderitem.OrderItem;

public interface OrderItemDAO {
    void addOrderItem(OrderItem orderItem);
    OrderItem getOrderItem(int orderItemId);
    List<OrderItem> getAllOrderItems();
    void updateOrderItem(OrderItem orderItem);
    void deleteOrderItem(int orderItemId);
}
