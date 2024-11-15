<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.tap.cartitem.CartItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* General Styling */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            margin: 0;
            padding: 0;
            color: #333;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        /* Header Styling */
        header {
            background: #3B5998;
            color: white;
            padding: 20px;
            text-align: center;
            position: relative;
        }

        header h1 {
            margin: 0;
            font-size: 2.5em;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }

        /* Back Button Styling */
        .back-button {
            position: absolute;
            top: 20px;
            left: 20px;
            padding: 10px 20px;
            background: #FF5722;
            color: white;
            font-size: 1em;
            border: none;
            border-radius: 50px;
            cursor: pointer;
            transition: background 0.3s ease;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .back-button:hover {
            background: #E64A19;
        }

        /* Clear Cart Button Styling */
        .clear-cart-button {
            position: absolute;
            top: 20px;
            right: 20px;
            padding: 10px 20px;
            background: #FF0000;
            color: white;
            font-size: 1em;
            border: none;
            border-radius: 50px;
            cursor: pointer;
            transition: background 0.3s ease;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .clear-cart-button:hover {
            background: #cc0000;
        }

        /* Cart Container */
        .cart-container {
            flex: 1;
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
            padding-bottom: 80px; /* To make space for the footer */
        }

        /* Cart Item Card */
        .cart-item {
            flex: 1 1 300px;
            background: #fff;
            border-radius: 15px;
            overflow: hidden;
            max-width: 400px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            position: relative;
            animation: slideIn 0.5s ease forwards;
        }

        @keyframes slideIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .cart-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
        }

        .cart-item img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }

        .cart-item-details {
            padding: 20px;
            display: flex;
            flex-direction: column;
            gap: 10px;
            align-items: center;
        }

        .cart-item h2 {
            font-size: 1.5em;
            color: #333;
            margin: 0;
        }

        .cart-item p {
            font-size: 1em;
            margin: 5px 0;
        }

        .price {
            font-size: 1.2em;
            color: #FF5722;
            font-weight: bold;
        }

        /* Quantity Selector Styling */
        .quantity-selector select {
            padding: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 1em;
            width: 70px;
        }

        /* Button Styles */
        .button-container {
            display: flex;
            gap: 10px;
            margin-top: 10px;
        }

        .remove-button {
            background: #FF5722;
            color: white;
            padding: 10px;
            font-size: 1em;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: background 0.3s ease;
            flex: 1;
            text-align: center;
        }

        .remove-button:hover {
            background: #E64A19;
        }

        /* Fixed Footer for Total and Checkout */
        .footer-section {
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            background: #fff;
            padding: 20px;
            box-shadow: 0 -4px 10px rgba(0, 0, 0, 0.15);
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 1.2em;
            color: #333;
            z-index: 10;
        }

        .footer-section .total-price {
            font-weight: bold;
        }

        .checkout-button {
            background: #28a745;
            color: white;
            padding: 10px 20px;
            font-size: 1em;
            border-radius: 50px;
            cursor: pointer;
            transition: background 0.3s ease;
            text-decoration: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            margin-right: 30px;
        }

        .checkout-button:hover {
            background: #218838;
        }
    </style>
</head>
<body>

<header>
    <h1>Your Cart</h1>
    <button class="back-button" onclick="window.location.href='getMenu.jsp';">Back</button>
    <!-- Clear Cart Button in Header -->
    <form action="clearCart" method="post" style="display:inline;">
        <button type="submit" class="clear-cart-button">Clear Cart</button>
    </form>
</header>

<div class="cart-container">
    <% 
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        double total = 0;
        if (cart != null && !cart.isEmpty()) {
            for (CartItem item : cart.values()) {
                double itemTotal = item.getPrice() * item.getQuantity();
                total += itemTotal;
    %>
        <div class="cart-item">
            <img src="<%= item.getImage() %>" alt="<%= item.getName() %>">
            <div class="cart-item-details">
                <h2><%= item.getName() %></h2>
                <p>Restaurant: <%= item.getRestaurant() %></p>
                <p class="price">$<%= String.format("%.2f", item.getPrice()) %></p>
                <p>Quantity: <%= item.getQuantity() %></p>
                <p>Subtotal: $<%= String.format("%.2f", itemTotal) %></p>
                <div class="quantity-selector">
                    <form action="updateCart" method="post">
                        <select name="quantity" onchange="this.form.submit()">
                            <% for (int i = 1; i <= 10; i++) { %>
                                <option value="<%= i %>" <%= i == item.getQuantity() ? "selected" : "" %>><%= i %></option>
                            <% } %>
                        </select>
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    </form>
                </div>
                <div class="button-container">
                    <form action="removeItem" method="post">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <button type="submit" class="remove-button">Remove</button>
                    </form>
                </div>
            </div>
        </div>
    <% 
            }
    %>
    <% 
        } else { 
    %>
        <p>Your cart is empty.</p>
    <% 
        } 
    %>
</div>

<% if (cart != null && !cart.isEmpty()) { %>
    <div class="footer-section">
        <span class="total-price">Total: $<%= String.format("%.2f", total) %></span>
        <% session.setAttribute("cartTotal", total); %>
        <a href="checkout.jsp" class="checkout-button">Proceed to Checkout</a>
    </div>
<% } %>

</body>
</html>
