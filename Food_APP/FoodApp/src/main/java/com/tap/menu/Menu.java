package com.tap.menu;

public class Menu {
    private int menuId;
    private int restaurantId;
    private String menuName;
    private String description;
    private double price;
    private float rating;
    private boolean isAvailable;
    private String image;  // Change to String

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getImage() {
        return image;  // Change to String
    }

    public void setImage(String image) {  // Change to String
        this.image = image;
    }

    public Menu(int menuId, int restaurantId, String menuName, String description, double price, float rating,
                boolean isAvailable, String image) {  // Change to String
        super();
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.menuName = menuName;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.isAvailable = isAvailable;
        this.image = image;  // Change to String
    }

    public Menu(String menuName, String description, double price, float rating, boolean isAvailable, String image) {  // Change to String
        super();
        this.menuName = menuName;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.isAvailable = isAvailable;
        this.image = image;  // Change to String
    }

    @Override
    public String toString() {
        return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", menuName=" + menuName + ", description="
                + description + ", price=" + price + ", rating=" + rating + ", isAvailable=" + isAvailable + ", image="
                + image + "]";  // Change to String
    }

    public Menu() {
        super();
    }
}