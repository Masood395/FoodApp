<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.menu.Menu" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Details</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* General Styling */
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #f6d365 0%, #fda085 100%);
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            color: #333;
        }

        /* Header Styling */
        header {
            background: #2C3E50;
            color: white;
            padding: 20px;
            text-align: center;
            position: relative;
            width: 100%;
        }

        header h1 {
            margin: 0;
            font-size: 2.5em;
            font-weight: bold;
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

        /* Cart Icon Styling */
        .cart-icon {
            position: absolute;
            top: 20px;
            right: 65px;
            background: #FF5722;
            color: white;
            border: none;
            border-radius: 50%;
            padding: 10px;
            cursor: pointer;
            transition: transform 0.3s ease, background 0.3s ease;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .cart-icon:hover {
            transform: scale(1.1);
            background: #E64A19;
        }

        .item-count {
            position: absolute;
            top: -10px;
            right: -10px;
            background: #FF5722;
            color: white;
            font-size: 1em;
            border-radius: 50%;
            padding: 3px 8px;
            font-weight: bold;
        }

        /* Grid Container for Cards */
        .container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            padding: 40px;
            justify-items: center;
        }

        /* Card Styling */
        .card {
            background: #fff;
            border-radius: 15px;
            overflow: hidden;
            width: 100%;
            max-width: 350px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.25);
        }

        .card img {
            width: 100%;
            height: 250px;
            object-fit: cover;
        }

        .card-body {
            padding: 20px;
            text-align: center;
        }

        .card h2 {
            font-size: 1.8em;
            color: #333;
            margin: 10px 0;
        }

        .price {
            font-size: 1.4em;
            color: #FF5722;
            font-weight: bold;
            margin: 10px 0;
        }

        .rating {
            font-size: 1em;
            color: #FFC107;
            margin: 5px 0;
        }

        .availability {
            font-weight: bold;
            margin-top: 5px;
            color: #555;
        }

        .available {
            color: #4CAF50;
        }

        .not-available {
            color: #E74C3C;
        }

        .add-to-cart {
            background: #28a745;
            color: white;
            border: none;
            border-radius: 30px;
            padding: 10px 20px;
            font-size: 1em;
            cursor: pointer;
            transition: background 0.3s ease;
            margin-top: 15px;
            width: 100%;
        }

        .add-to-cart:hover {
            background: #218838;
        }

        .quantity-selector {
            margin-top: 15px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .quantity-selector select {
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-right: 10px;
            font-size: 1em;
        }

        /* Footer Styling */
        footer {
            background: rgba(44, 62, 80, 0.9);
            padding: 20px;
            text-align: center;
            color: #fff;
            margin-top: 20px;
        }

        footer p {
            margin: 5px 0;
        }

        .social-icons a {
            margin: 0 10px;
            color: #08eee5;
            font-size: 20px;
            transition: color 0.3s;
            text-decoration: none;
        }

        .social-icons a:hover {
            color: #ff5722;
        }

        /* Popup Styling */
        .popup {
            display: none;
            position: fixed;
            top: 90%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: rgba(0, 0, 0, 0.8);
            color: white;
            padding: 20px;
            border-radius: 10px;
            z-index: 1000;
            text-align: center;
        }

        .popup.active {
            display: block;
        }

        .popup button {
            background-color: #FF5722;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 5px;
            font-size: 1em;
            margin-top: 15px;
        }

        .popup button:hover {
            background-color: #E64A19;
        }

        /* Responsive Styling */
        @media (max-width: 768px) {
            header h1 {
                font-size: 2em;
            }
            .container {
                padding: 20px;
            }
        }

        @media (max-width: 480px) {
            header h1 {
                font-size: 1.5em;
            }
            .back-button {
                padding: 6px 12px;
                font-size: 0.9em;
            }
            .cart-icon {
                padding: 8px;
                font-size: 0.9em;
            }
        }
    </style>
</head>
<body>

<header>
    <h1>Menu Details</h1>
    <button class="back-button" onclick="window.location.href='home.jsp';">Back</button>
    <button class="cart-icon" onclick="window.location.href='cart.jsp';">
    <i class="fas fa-shopping-cart"></i>
    <% 
        Integer cartItemCount = (Integer) session.getAttribute("cartItemCount");
        if (cartItemCount != null && cartItemCount > 0) { 
    %>
        <span class="item-count"><%= cartItemCount %></span>
    <% } %>
</button>

</header>

<div class="container">
    <%
        List<Menu> mList = (List<Menu>) session.getAttribute("menuList");
        if (mList != null && !mList.isEmpty()) {
            for(Menu mnu : mList) {
    %>
        <div class="card">
            <img src="<%= mnu.getImage() %>" alt="<%= mnu.getMenuName() %>">
            <div class="card-body">
                <h2><%= mnu.getMenuName() %></h2>
                <p><strong>Description:</strong> <%= mnu.getDescription() %></p>
                <p class="price">$<%= mnu.getPrice() %></p>
                <p class="rating">Rating: <%= mnu.getRating() %> / 5</p>
                <p class="availability <%= mnu.isAvailable() ? "available" : "not-available" %>">
                    <%= mnu.isAvailable() ? "Available" : "Not Available" %>
                </p>
                <div class="quantity-selector">
                    <form action="addcartcntrl" method="post">
                        <select name="quantity">
                            <% for (int i = 1; i <= 10; i++) { %>
                                <option value="<%= i %>"><%= i %></option>
                            <% } %>
                        </select>
                        <input type="hidden" name="id" value="<%= mnu.getMenuId() %>">
                        <input type="hidden" name="img" value="<%= mnu.getImage() %>">
                        <button type="submit" class="add-to-cart">Add to Cart</button>
                    </form>
                </div>
            </div>
        </div>
    <% 
            }
        } else {
            out.println("<p>No menu items available.</p>");
        }
    %>
</div>

<%-- Check if item was added to cart and show pop-up --%>
<%
    Boolean itemAdded = (Boolean) session.getAttribute("itemAdded");
    if (itemAdded != null && itemAdded) {
        session.setAttribute("itemAdded", false); // reset the flag after showing pop-up
%>
    <div class="popup active">
        <p>Item added to cart successfully!</p>
        <button onclick="window.location.href='cart.jsp';">Go to Cart</button>
    </div>
<%
    }
%>

<footer>
    <p>&copy; 2024 Your Restaurant App. All rights reserved.</p>
    <div class="social-icons">
        <a href="#" class="fab fa-facebook-f"></a>
        <a href="#" class="fab fa-twitter"></a>
        <a href="#" class="fab fa-instagram"></a>
    </div>
</footer>

</body>
</html>
