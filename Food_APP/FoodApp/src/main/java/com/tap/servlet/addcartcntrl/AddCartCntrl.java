package com.tap.servlet.addcartcntrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.cartdaoimpl.CartDAOImpl;
import com.tap.cartitem.CartItem;
import com.tap.menu.Menu;
import com.tap.menudao.MenuDAO;
import com.tap.menudaoimpl.MenuDaoImpl;

@WebServlet("/addcartcntrl")
public class AddCartCntrl extends HttpServlet {

    private CartDAOImpl cartDAO;

    @Override
    public void init() throws ServletException {
        cartDAO = new CartDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve cart from session
        Map<Integer, CartItem> sessionCart = (Map<Integer, CartItem>) req.getSession().getAttribute("cart");
        if (sessionCart == null) {
            sessionCart = new HashMap<>(); // Initialize a new cart if it doesn't exist
            req.getSession().setAttribute("cart", sessionCart);
        }
        if (sessionCart != null) {
            cartDAO.setItems(sessionCart); // Load existing cart items into DAO
        }
        

        // Get parameters
        int menuId = Integer.parseInt(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String image = req.getParameter("img");

        MenuDAO menuDAO = new MenuDaoImpl();
        Menu menu = menuDAO.getById(menuId);

        // Create CartItem and add it to the cart via DAO
        CartItem cartItem = new CartItem(menuId, menu.getRestaurantId(), menu.getMenuName(), quantity, menu.getPrice(), image);
        cartDAO.addItem(cartItem);

        // Store updated cart in session
        req.getSession().setAttribute("cart", cartDAO.getItems());
     // Assuming this is part of the addcartcntrl servlet where the item is being added to the cart.
        req.getSession().setAttribute("itemAdded", true);  // Set the flag for item added
 

        req.getSession().setAttribute("cartItemCount", cartDAO.getItems().size());

        // Add the item to the cart (existing code to add item)



        // Redirect to menu page
        resp.sendRedirect("getMenu.jsp");
    }
}
