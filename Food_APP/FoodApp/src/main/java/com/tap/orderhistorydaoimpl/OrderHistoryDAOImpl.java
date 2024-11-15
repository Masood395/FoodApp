package com.tap.orderhistorydaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.database.MyConnect;
import com.tap.orderhistory.OrderHistory;
import com.tap.orderhistorydao.OrderHistoryDAO;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {
    private Connection connection;

    public OrderHistoryDAOImpl() {
        connection = MyConnect.connect();;
    }

    @Override
    public void addOrderHistory(OrderHistory orderHistory) {
        String sql = "INSERT INTO order_history (order_id, user_id, restaurant_id, total, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderHistory.getOrderId());
            pstmt.setInt(2, orderHistory.getUserId());
            pstmt.setInt(3, orderHistory.getRestaurantId());
            pstmt.setDouble(4, orderHistory.getTotal());
            pstmt.setString(5, orderHistory.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderHistory getOrderHistory(int orderHistoryId) {
        String sql = "SELECT * FROM order_history WHERE order_history_id = ?";
        OrderHistory orderHistory = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderHistoryId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                orderHistory = new OrderHistory();
                orderHistory.setOrderHistoryId(rs.getInt("order_history_id"));
                orderHistory.setOrderId(rs.getInt("order_id"));
                orderHistory.setUserId(rs.getInt("user_id"));
                orderHistory.setRestaurantId(rs.getInt("restaurant_id"));
                orderHistory.setTotal(rs.getDouble("total"));
                orderHistory.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    @Override
    public List<OrderHistory> getAllOrderHistories() {
        List<OrderHistory> orderHistories = new ArrayList<>();
        String sql = "SELECT * FROM order_history";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setOrderHistoryId(rs.getInt("order_history_id"));
                orderHistory.setOrderId(rs.getInt("order_id"));
                orderHistory.setUserId(rs.getInt("user_id"));
                orderHistory.setRestaurantId(rs.getInt("restaurant_id"));
                orderHistory.setTotal(rs.getDouble("total"));
                orderHistory.setStatus(rs.getString("status"));
                orderHistories.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistories;
    }

    @Override
    public void updateOrderHistory(OrderHistory orderHistory) {
        String sql = "UPDATE order_history SET order_id = ?, user_id = ?, restaurant_id = ?, total = ?, status = ? WHERE order_history_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderHistory.getOrderId());
            pstmt.setInt(2, orderHistory.getUserId());
            pstmt.setInt(3, orderHistory.getRestaurantId());
            pstmt.setDouble(4, orderHistory.getTotal());
            pstmt.setString(5, orderHistory.getStatus());
            pstmt.setInt(6, orderHistory.getOrderHistoryId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderHistory(int orderHistoryId) {
        String sql = "DELETE FROM order_history WHERE order_history_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderHistoryId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
