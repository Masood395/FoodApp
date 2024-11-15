package com.tap.servlet.getmenu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.menu.Menu;
import com.tap.menudao.MenuDAO;
import com.tap.menudaoimpl.MenuDaoImpl;


@WebServlet("/getmenu")
public class Fetchmenu extends HttpServlet {
	
	private List<Menu> menuList;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		MenuDAO mdao = new MenuDaoImpl();
		menuList = mdao.getByRestaurantId(id);
		HttpSession session = req.getSession();
		session.setAttribute("menuList",menuList );
		
		resp.sendRedirect("getMenu.jsp");
		
	}
	
}
