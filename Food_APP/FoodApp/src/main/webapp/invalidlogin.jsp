<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Invalid Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da; /* Light pink background */
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
            color: #721c24; /* Dark red color */
            margin-bottom: 10px;
        }
        p {
            color: #856404; /* Dark yellow for the message */
            margin-bottom: 20px;
        }
        button {
            background-color: #721c24; /* Dark red */
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #c82333; /* Brighter red on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Invalid Login!</h1>
        <p>Sorry, the email you entered was not found. Please check your credentials and try again.</p>
        <button onclick="window.location.href='Login.jsp'">Back to Login</button>
    </div>
</body>
</html>