package com.rain.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rain.javabean.EmployeeBean;

public class EmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = (String) request.getParameter("method");
		if (method == null) {
			PrintWriter out = response.getWriter();
			out.println("invalid request!");
		} else if (method.equals("login")) {
			Login(request, response);
		} else if (method.equals("logout")) {
			Logout(request, response);
		} 
	}

	protected void Login(HttpServletRequest request,     
			HttpServletResponse response) throws ServletException, IOException {    
		// get parameters      
		System.out.println("Login 1");
		String account = request.getParameter("account");      
		String password = request.getParameter("password");       
		System.out.println("Login 2");
		// check null      
		if (account == null || password == null) {          
			response.sendRedirect("login.jsp");          
			return;      
		}       
		System.out.println("Login 3");
		// validate      
		EmployeeBean bean = new EmployeeBean();      
		boolean isValid = bean.valid(account, password);
		if (isValid) {
			HttpSession session = request.getSession();          
			session.setAttribute("account", account);          
			response.sendRedirect("home.jsp");          
			return;      
		} else {          
				response.sendRedirect("login.jsp");         
				return;     
		} 
	}

	protected void Logout(HttpServletRequest request,         
			HttpServletResponse response) throws ServletException, IOException {      
		HttpSession session = request.getSession();      
		session.removeAttribute("account");      
		response.sendRedirect("login.jsp");  
	}

//	protected void Register(HttpServletRequest request, 
//			HttpServletResponse response)          throws ServletException, IOException {      
//		// get parameters      
//		String username = request.getParameter("username");      
//		String password1 = request.getParameter("password1");      
//		String password2 = request.getParameter("password2");      
//		String email = request.getParameter("email");       
//		// check null      
//		if (username == null || password1 == null ||
//			password2 == null || !password1.equals(password2)) {          
//			response.sendRedirect("register.jsp");          
//			return;      
//		}       
//		// validate      
//		AdminBean userBean = new AdminBean();      
//		boolean isExist = userBean.isExist(username);      
//		if(!isExist) {          
//			userBean.add(username, password1, email);          
//			response.sendRedirect("login.jsp");          
//			return;      
//		} else {          
//			response.sendRedirect("register.jsp");          
//			return;      
//		}  
//	} 
}