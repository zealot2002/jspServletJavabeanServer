package com.rain.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rain.util.EncoderHandler;

public class CodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = (String) request.getParameter("method");
		try {
			if (method == null) {
				PrintWriter out = response.getWriter();
				out.println("invalid request!");
			} else if (method.equals("showQrcode")) {
				showQrcode(request, response);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showQrcode(HttpServletRequest request, HttpServletResponse response){
		try {
			String content = (String) request.getParameter("content");
			System.out.println("showQrcode : content = "+content);
			EncoderHandler encoder = new EncoderHandler();
			encoder.encoderQRCoder(content, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
