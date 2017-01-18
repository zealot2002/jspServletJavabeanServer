package com.rain.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rain.javabean.EmployeeBean;
import com.rain.javabean.DoctorBean;
import com.rain.javabean.MedicalRecordBean;
import com.rain.javabean.PatientBean;
import com.rain.pojo.PatientBO;

public class ShowImgServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = (String) request.getParameter("method");
		try {
			if (method == null) {
				PrintWriter out = response.getWriter();
				out.println("invalid request!");
			} else if (method.equals("showImg")) {
				showImg(request, response);
			} else if (method.equals("showQrcode")) {
				showQrcode(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showQrcode(HttpServletRequest request,     
			HttpServletResponse response) throws SQLException, Exception {
		String content = (String) request.getParameter("content");
		request.getSession().setAttribute("content", content);
		response.sendRedirect("showQrcode.jsp");  
	}
	
	private void showImg(HttpServletRequest request,     
			HttpServletResponse response) throws SQLException, Exception {
		String imgUri = (String) request.getParameter("imgUri");
		request.getSession().setAttribute("imgUri", imgUri);
		response.sendRedirect("showImg.jsp");  
	}
}