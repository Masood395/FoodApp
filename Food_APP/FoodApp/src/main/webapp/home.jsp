<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.restaurant.Restaurant" %>
<%@ page import="com.tap.user.User" %>
<%@ page import="com.tap.security.Security" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurant Details</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* General Styling */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #ff7e5f, #feb47b);
            color: #fff;
        }

        a {
            text-decoration: none;
            color: inherit;
        }

        /* Header Styling */
        header {
            background-color: rgba(44, 62, 80, 0.9);
            padding: 20px;
            text-align: center;
            position: relative;
        }

        header h1 {
            color: #08eee5;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
            margin: 0;
        }

        .nav {
            margin-top: 10px;
        }

        .nav a {
            margin: 0 15px;
            color: #08eee5;
            font-weight: bold;
            transition: color 0.3s;
        }

        .nav a:hover {
            color: #ff5722;
        }

        /* Logout Icon */
        .logout {
            position: absolute;
            top: 20px;
            right: 20px;
            color: #ff5722;
            font-size: 24px;
            cursor: pointer;
            transition: transform 0.3s, color 0.3s;
        }

        .logout:hover {
            transform: scale(1.2);
            color: #e64a19;
        }

        /* Search Bar */
        .search-container {
            text-align: center;
            margin: 20px 0;
        }

        .search-container input[type="text"] {
            padding: 10px;
            width: 300px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
        }

        .search-container button {
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            background-color: #ff5722;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .search-container button:hover {
            background-color: #e64a19;
        }

        /* Container and Card Styling */
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .card {
            background-color: #e2b1aa;
            border-radius: 10px;
            padding: 20px;
            width: 100%;
            max-width: 300px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
            transition: transform 0.3s, box-shadow 0.3s;
            position: relative;
            overflow: hidden;
            text-align: center;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.5);
        }

        .card img {
            max-width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 10px;
        }

        .card h2 {
            margin: 10px 0;
            color: #ff5722;
            font-size: 24px;
        }

        .card p {
            margin: 5px 0;
            color: #152d2a;
            font-size: 16px;
        }

        .card p strong {
            color: #ff5722;
        }

        /* Footer Styling */
        footer {
            background-color: rgba(44, 62, 80, 0.9);
            padding: 20px;
            text-align: center;
            color: #fff;
            position: relative;
            margin-top: 20px;
        }

        footer p {
            margin: 5px 0;
        }

        .social-icons {
            margin: 10px 0;
        }

        .social-icons a {
            margin: 0 10px;
            color: #08eee5;
            font-size: 20px;
            transition: color 0.3s;
        }

        .social-icons a:hover {
            color: #ff5722;
        }

        /* Responsive Grid Layout */
        @media (min-width: 768px) {
            .card {
                flex: 0 0 45%; /* 2 cards per row on medium screens */
            }
        }

        @media (min-width: 1024px) {
            .card {
                flex: 0 0 30%; /* 3 cards per row on large screens */
            }
        }
    </style>
</head>
<body>
<%
    List<Restaurant> rList = (List<Restaurant>) session.getAttribute("restaurantList");
    User user = (User) session.getAttribute("loggedInUser");
%>

<header>
    <h1>Welcome <% out.println(Security.decryption(user.getUsername())); %></h1>
    <div class="nav">
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Contact</a>
    </div>
    <!-- Logout Icon -->
    <a href="logout" class="logout">
        <i class="fas fa-sign-out-alt"></i> Logout
    </a>
</header>

<!-- Search Bar -->
<div class="search-container">
    <input type="text" id="searchInput" placeholder="Search for restaurants..." onkeyup="filterRestaurants()">
    <button onclick="filterRestaurants()">Search</button>
</div>

<div class="container" id="restaurantContainer">
    <% 
        if (rList != null && !rList.isEmpty()) {
            for (Restaurant rst : rList) {
    %>
        <a href="getmenu?id=<%= rst.getRid() %>" class="card" data-name="<%= rst.getName().toLowerCase() %>">
            <img src="<%= rst.getImage() %>" alt="<%= rst.getName() %>">
            <h2><%= rst.getName() %></h2>
            <p><strong>Cuisine Type:</strong> <%= rst.getCuisineType() %></p>
            <p><strong>Address:</strong> <%= rst.getAddress() %></p>
            <p><strong>Rating:</strong> <%= rst.getRating() %></p>
            <p><strong>Delivery Time:</strong> <%= rst.getDeliveryTime() %></p>
            <p><strong>Active:</strong> <%= rst.isActive() ? "Yes" : "No" %></p>
        </a>
    <% 
            }
        } else {
            out.println("<p>No restaurants available.</p>");
        }
    %>
</div>

<!-- Footer -->
<footer>
    <p>&copy; 2024 Your Restaurant App. All rights reserved.</p>
    <div class="social-icons">
        <a href="#" class="fab fa-facebook-f"></a>
        <a href="#" class="fab fa-twitter"></a>
        <a href="#" class="fab fa-instagram"></a>
    </div>
</footer>

<script>
    function filterRestaurants() {
        const input = document.getElementById('searchInput');
        const filter = input.value.toLowerCase();
        const container = document.getElementById('restaurantContainer');
        const cards = container.getElementsByClassName('card');

        for (let i = 0; i < cards.length; i++) {
            const card = cards[i];
            const name = card.getAttribute('data-name');
            if (name.includes(filter)) {
                card.style.display = '';
            } else {
                card.style.display = 'none';
            }
        }
    }
</script>

</body>
</html>
