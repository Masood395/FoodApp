package com.tap.menudaoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.database.MyConnect;
import com.tap.menu.Menu;
import com.tap.menudao.MenuDAO;

public class MenuDaoImpl implements MenuDAO {
    private Connection connection;

    public MenuDaoImpl() {
        connection = MyConnect.connect();
    }

    @Override
    public Menu create(Menu menu) {
        String sql = "INSERT INTO menu (restaurant_id, menu_name, description, price, rating, is_available, image) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getMenuName());
            stmt.setString(3, menu.getDescription());
            stmt.setDouble(4, menu.getPrice());
            stmt.setFloat(5, menu.getRating());
            stmt.setBoolean(6, menu.isAvailable());
            stmt.setString(7, menu.getImage());  // Use setString for String
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                menu.setMenuId(generatedKeys.getInt(1));
            }
            return menu;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Menu getById(int menuId) {
        String sql = "SELECT * FROM menu WHERE menu_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, menuId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Menu(
                    rs.getInt("menu_id"),
                    rs.getInt("restaurant_id"),
                    rs.getString("menu_name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getFloat("rating"),
                    rs.getBoolean("is_available"),
                    rs.getString("image")  // Use getString for String
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Menu> getByRestaurantId(int restaurantId) {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * FROM menu WHERE restaurant_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, restaurantId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                menus.add(new Menu(
                    rs.getInt("menu_id"),
                    rs.getInt("restaurant_id"),
                    rs.getString("menu_name"),
                    rs.getString("description"),
                    rs.getDouble("price"),
                    rs.getFloat("rating"),
                    rs.getBoolean("is_available"),
                    rs.getString("image")  // Use getString for String
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public Menu update(Menu menu) {
        String sql = "UPDATE menu SET restaurant_id = ?, menu_name = ?, description = ?, price = ?, rating = ?, is_available = ?, image = ? WHERE menu_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getMenuName());
            stmt.setString(3, menu.getDescription());
            stmt.setDouble(4, menu.getPrice());
            stmt.setFloat(5, menu.getRating());
            stmt.setBoolean(6, menu.isAvailable());
            stmt.setString(7, menu.getImage());  // Use setString for String
            stmt.setInt(8, menu.getMenuId());
            stmt.executeUpdate();
            return menu;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int menuId) {
        String sql = "DELETE FROM menu WHERE menu_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, menuId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}