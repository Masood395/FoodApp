package com.tap.cartdaoimpl;

import java.util.HashMap;
import java.util.Map;

import com.tap.cartitem.CartItem;

public class CartDAOImpl {

    private Map<Integer, CartItem> items;

    public CartDAOImpl() {
        this.items = new HashMap<>();
    }

    // Add item to the cart
    public void addItem(CartItem item) {
        int itemId = item.getItemId();

        if (items.containsKey(itemId)) {
            CartItem existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity()); // Update quantity
        } else {
            items.put(itemId, item); // Add new item to cart
        }
    }

    // Set items from session or external source
    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    // Get items in the cart
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                items.remove(itemId);
            } else {
                items.get(itemId).setQuantity(quantity);
            }
        }
    }

    public void removeItem(int itemId) {
        items.remove(itemId);
    }

    public void clear() {
        items.clear();
    }
}
