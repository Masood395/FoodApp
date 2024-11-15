package com.tap.order;

public class Order {
    private int orderId;
    private int userId;
    private int restaurantId;
    private int menuId;
    private int quantity;
    private double totalAmount;
    private String paymentMethod;
    private String status;

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Order() {
		super();
	}

	public Order(int userId, int restaurantId, int menuId, int quantity, double totalAmount, String paymentMethod,
			String status) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", menuId="
				+ menuId + ", quantity=" + quantity + ", totalAmount=" + totalAmount + ", paymentMethod="
				+ paymentMethod + ", status=" + status + "]";
	}
    
    
}
