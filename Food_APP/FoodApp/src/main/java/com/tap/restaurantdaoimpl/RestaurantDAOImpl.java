package com.tap.restaurantdaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.database.MyConnect;
import com.tap.restaurant.Restaurant;
import com.tap.restaurantdao.RestaurantDAO;

public class RestaurantDAOImpl implements RestaurantDAO {
    private Connection connection;

    public RestaurantDAOImpl() {
        connection = MyConnect.connect();
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        String sql = "INSERT INTO restaurant (name, cuisine_type, address, rating, delivery_time, is_active, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getCuisineType());
            stmt.setString(3, restaurant.getAddress());
            stmt.setFloat(4, restaurant.getRating());
            stmt.setInt(5, restaurant.getDeliveryTime());
            stmt.setBoolean(6, restaurant.isActive());
            stmt.setString(7, restaurant.getImage());  // Use setString for String
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                restaurant.setRid(generatedKeys.getInt(1));
            }
            return restaurant;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Restaurant getById(int rid) {
        String sql = "SELECT * FROM restaurant WHERE rid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Restaurant(
                    rs.getInt("rid"),
                    rs.getString("name"),
                    rs.getString("cuisine_type"),
                    rs.getString("address"),
                    rs.getFloat("rating"),
                    rs.getInt("delivery_time"),
                    rs.getBoolean("is_active"),
                    rs.getString("image")  // Use getString for String
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurant";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                restaurants.add(new Restaurant(
                    rs.getInt("rid"),
                    rs.getString("name"),
                    rs.getString("cuisine_type"),
                    rs.getString("address"),
                    rs.getFloat("rating"),
                    rs.getInt("delivery_time"),
                    rs.getBoolean("is_active"),
                    rs.getString("image")  // Use getString for String
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        String sql = "UPDATE restaurant SET name = ?, cuisine_type = ?, address = ?, rating = ?, delivery_time = ?, is_active = ?, image = ? WHERE rid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getCuisineType());
            stmt.setString(3, restaurant.getAddress());
            stmt.setFloat(4, restaurant.getRating());
            stmt.setInt(5, restaurant.getDeliveryTime());
            stmt.setBoolean(6, restaurant.isActive());
            stmt.setString(7, restaurant.getImage());  // Use setString for String
            stmt.setInt(8, restaurant.getRid());
            stmt.executeUpdate();
            return restaurant;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int rid) {
        String sql = "DELETE FROM restaurant WHERE rid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, rid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}