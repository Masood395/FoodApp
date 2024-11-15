package com.tap.servlet.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.security.Security;
import com.tap.user.User;
import com.tap.userdao.UserDAO;
import com.tap.userdaoimpl.UserDAOImpl;


@WebServlet("/registerData")
public class Register extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		User u=new User(Security.encryption(req.getParameter("name")),Security.encryption(req.getParameter("email")),Security.encryption(req.getParameter("pwd")),Security.encryption(req.getParameter("mobile")));
		UserDAO udao=new UserDAOImpl();
		int status = udao.insert(u);
		if(status!=0) {
			
			resp.sendRedirect("registersuccess.jsp");
			
		}
		else {

			resp.sendRedirect("failure.jsp");
			
		}
		
		
	}
	
}
