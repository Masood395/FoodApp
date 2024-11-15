package com.tap.servlet.updateCart;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.cartdaoimpl.CartDAOImpl;
import com.tap.cartitem.CartItem;


@WebServlet("/updateCart")
public class UpdateCart extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CartDAOImpl cdao = new CartDAOImpl();
		Map<Integer, CartItem> sessionCart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if (sessionCart != null) {
            cdao.setItems(sessionCart); // Load existing cart items into DAO
        }
        
		int menuId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		cdao.updateItem(menuId, quantity);
		Map<Integer, CartItem> cart = cdao.getItems();
//		System.out.println(cart);
		 req.getSession().setAttribute("cart",cart );
		resp.sendRedirect("cart.jsp");

	}

}
