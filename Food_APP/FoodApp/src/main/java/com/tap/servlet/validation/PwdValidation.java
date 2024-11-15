package com.tap.servlet.validation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/validation")
public class PwdValidation extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String password=req.getParameter("pwd");
		String confirmpassword=req.getParameter("cpwd");
		
		if(password.equals(confirmpassword)) {
			
			req.getRequestDispatcher("registerData").forward(req, resp);
			
		}
else {
			
			resp.sendRedirect("pwdmismatch.jsp");
		}
		
		
	}
}
