package com.ravi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ravi.model.Login;
import com.ravi.service.LoginService;
import com.ravi.services.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginService = new LoginServiceImpl();
		Login login = new Login();
		login.setUsername(request.getParameter("user"));
		login.setPassword(request.getParameter("password"));

		if(loginService.authenticate(login).isResult()){
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");  
	        rd.forward(request,response);  
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("fail.jsp");  
	        rd.include(request,response);  
		}
	}

}
