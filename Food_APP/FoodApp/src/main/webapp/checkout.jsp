<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* Styling for the checkout form */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .checkout-container {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 500px;
            width: 100%;
            text-align: center;
        }

        h2 {
            font-size: 2em;
            color: #3B5998;
            margin-bottom: 20px;
        }

        .total-amount {
            font-size: 1.5em;
            color: #FF5722;
            margin-bottom: 20px;
        }

        .payment-form input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 1em;
        }

        .pay-button {
            background: #28a745;
            color: white;
            padding: 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.2em;
            margin-top: 20px;
            transition: background 0.3s ease;
        }

        .pay-button:hover {
            background: #218838;
        }
    </style>
</head>
<body>

<div class="checkout-container">
    <h2>Payment</h2>
    
    <% 
        // Retrieve the total amount from the session
        Double total = (Double) session.getAttribute("cartTotal");
        if (total == null) {
            total = 0.0;
        }
    %>
    
    <div class="total-amount">Total Amount: $<%= String.format("%.2f", total) %></div>
    
    <form action="processPayment" method="post" class="payment-form">
        <input type="text" name="cardNumber" placeholder="Card Number" required>
        <input type="text" name="cardName" placeholder="Name on Card" required>
        <input type="text" name="expiryDate" placeholder="Expiry Date (MM/YY)" required>
        <input type="text" name="cvv" placeholder="CVV" required>
        
        <button type="submit" class="pay-button">Pay $<%= String.format("%.2f", total) %></button>
    </form>
</div>

</body>
</html>
