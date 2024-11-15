<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffebee; /* Light red background */
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
            color: #d32f2f; /* Red color */
            margin-bottom: 10px;
        }
        p {
            color: #555; /* Darker gray for the message */
            margin-bottom: 20px;
        }
        button {
            background-color: #d32f2f; /* Red */
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #b71c1c; /* Darker red */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Login Failed!</h1>
        <p>Oops! The password you entered does not match our records. Please try again.</p>
        <button onclick="window.location.href='Login.jsp'">Back to Login</button>
    </div>
</body>
</html>