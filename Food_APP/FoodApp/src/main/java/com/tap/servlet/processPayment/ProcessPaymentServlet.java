package com.tap.servlet.processPayment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processPayment")
public class ProcessPaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Here you would process payment details
        String cardNumber = req.getParameter("cardNumber");
        String cardName = req.getParameter("cardName");
        String expiryDate = req.getParameter("expiryDate");
        String cvv = req.getParameter("cvv");

        // Mock payment processing logic
        boolean paymentSuccessful = true; // In a real system, integrate with a payment gateway

        if (paymentSuccessful) {
            // Clear cart after payment
            req.getSession().removeAttribute("cart");
            req.getSession().setAttribute("cartTotal", 0.0);

            // Redirect to payment confirmation page
            resp.sendRedirect("paymentConfirmation.jsp");
        } else {
            // Payment failed, redirect back to checkout with error message
            req.setAttribute("error", "Payment failed. Please try again.");
            req.getRequestDispatcher("checkout.jsp").forward(req, resp);
        }
    }
}
