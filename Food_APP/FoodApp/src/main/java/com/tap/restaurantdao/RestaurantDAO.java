package com.tap.restaurantdao;

import java.util.List;

import com.tap.restaurant.Restaurant;

public interface RestaurantDAO {
    Restaurant create(Restaurant restaurant);
    Restaurant getById(int rid);
    List<Restaurant> getAll();
    Restaurant update(Restaurant restaurant);
    void delete(int rid);
}
