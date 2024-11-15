package com.tap.servlet.getrestaurant;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.restaurant.Restaurant;
import com.tap.restaurantdao.RestaurantDAO;
import com.tap.restaurantdaoimpl.RestaurantDAOImpl;


@WebServlet("/getrestaurant")
public class GetRestaurant extends HttpServlet {
	


	private List<Restaurant> restaurantList;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAO rdao=new RestaurantDAOImpl();
		restaurantList=rdao.getAll();
		HttpSession session = req.getSession();
		session.setAttribute("restaurantList", restaurantList);
		resp.sendRedirect("home.jsp");
		
	}
	
}
