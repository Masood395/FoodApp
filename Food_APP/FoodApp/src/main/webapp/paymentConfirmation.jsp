<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
    <style>
        /* Styling for confirmation page */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: linear-gradient(135deg, #c3f7fa, #a3cbe2);
            font-family: Arial, sans-serif;
        }
        
        .confirmation-container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 500px;
            width: 100%;
        }
        
        .confirmation-container h2 {
            color: #28a745;
            font-size: 2em;
        }
        
        .confirmation-container p {
            font-size: 1.2em;
            margin: 20px 0;
        }
        
        .confirmation-container .back-button {
            background: #3B5998;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 1em;
        }
        
        .confirmation-container .back-button:hover {
            background: #2e4a83;
        }
    </style>
</head>
<body>

<div class="confirmation-container">
    <h2>Payment Successful!</h2>
    <p>Thank you for your purchase. Your payment has been processed successfully.</p>
    <a href="getMenu.jsp" class="back-button">Back to Menu</a>
</div>

</body>
</html>
