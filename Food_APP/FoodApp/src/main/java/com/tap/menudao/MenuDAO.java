package com.tap.menudao;

import java.util.List;

import com.tap.menu.Menu;

public interface MenuDAO {
    Menu create(Menu menu);
    Menu getById(int menuId);
    List<Menu> getByRestaurantId(int restaurantId);
    Menu update(Menu menu);
    void delete(int menuId);
}
