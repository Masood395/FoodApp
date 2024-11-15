package com.tap.cartitem;


public class CartItem {

	private int itemId;
	private int restaurant;
	private String name;
	private int quantity;
	private double price;
	private String image;
	
	
	public CartItem(int itemId, int restaurant, String name, int quantity, double price, String image) {
		super();
		this.itemId = itemId;
		this.restaurant = restaurant;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.image = image;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public int getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", restaurant=" + restaurant + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + ", image=" + image + "]";
	}
	
	

	
	
	
}
