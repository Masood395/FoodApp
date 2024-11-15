package com.tap.servlet.removeItem;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.cartdaoimpl.CartDAOImpl;
import com.tap.cartitem.CartItem;


@WebServlet("/removeItem")
public class RemoveItem extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CartDAOImpl cdao = new CartDAOImpl();
		Map<Integer, CartItem> sessionCart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if (sessionCart != null) {
            cdao.setItems(sessionCart); // Load existing cart items into DAO
        }
        
		int menuId = Integer.parseInt(req.getParameter("itemId"));
		
		cdao.removeItem(menuId);
		Map<Integer, CartItem> cart = cdao.getItems();
		 req.getSession().setAttribute("cart",cart );


		 req.getSession().setAttribute("cartItemCount", cdao.getItems().size());

		 // Add the item to the cart (existing code to add item)

		 
		resp.sendRedirect("cart.jsp");

	}
	
	
}
