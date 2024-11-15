<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import=" com.tap.user.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa; /* Light blue background */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 40px;
            width: 300px;
        }
        h1 {
            color: #00796b; /* Teal color */
            margin-bottom: 10px;
        }
        p {
            color: #555; /* Darker gray for the message */
            margin-bottom: 20px;
        }
        button {
            background-color: #00796b; /* Teal */
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #004d40; /* Darker teal */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login Successful!</h1>
        <p>Welcome back
         <%
         User user = (User)session.getAttribute("loggedInUser");
        	out.println(user.getUsername());
        %>
        ! You have successfully logged in.</p>
        <button onclick="window.location.href=''">Go to Dashboard</button>
    </div>
</body>
</html>