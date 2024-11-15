package com.tap.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.security.Security;
import com.tap.user.User;
import com.tap.userdao.UserDAO;
import com.tap.userdaoimpl.UserDAOImpl;


@WebServlet("/loginData")
public class Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String email=Security.encryption(req.getParameter("email"));
		String password=Security.encryption(req.getParameter("pwd"));
		
		UserDAO udao=new UserDAOImpl();
		User u = udao.fetchSpecific(email);
//		resp.getWriter().println(u);
		
		if(u!=null) {
			
			if(u.getPassword().equals(password)) {
				
				HttpSession session = req.getSession(true);
				session.setAttribute("loggedInUser", u);
				
//				resp.sendRedirect("loginsuccess.jsp");
				resp.sendRedirect("getrestaurant");

			}
			else {
				
				resp.sendRedirect("loginfailure.jsp");

				
			}
			
		}
		else {
			resp.sendRedirect("invalidlogin.jsp");
		}
		
	}
	
}
