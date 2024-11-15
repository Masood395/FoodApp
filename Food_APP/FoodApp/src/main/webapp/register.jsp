<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 40px;
            width: 400px;
        }
        h2 {
            text-align: center;
            color: #4CAF50; /* Green color */
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #4CAF50; /* Green */
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049; /* Darker green */
        }
        .footer {
            text-align: center;
            margin-top: 20px;
        }
        .footer a {
            color: #4CAF50;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Register</h2>
        <form action="validation" method="POST">
            <label for="name">Name</label>
            <input type="text" name="name" placeholder="Enter your full name" required>

            <label for="email">Email</label>
            <input type="email" name="email" placeholder="example@domain.com" required>

            <label for="mobile">Mobile Number</label>
            <input type="text" name="mobile" placeholder="e.g., 123-456-7890" minlength="10" maxlength="10" required>

            <label for="pwd">Password</label>
            <input type="password" name="pwd" placeholder="Create a password (min 5 characters)" minlength="4" required>

            <label for="cpwd">Confirm Password</label>
            <input type="password" name="cpwd" placeholder="Re-enter your password" minlength="4" required>


            <input type="submit" value="Register">
        </form>
        <div class="footer">
            <p>Already have an account? <a href="Login.jsp">Login here</a></p>
        </div>
    </div>
</body>
</html>