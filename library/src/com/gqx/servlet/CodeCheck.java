package com.gqx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeCheck extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code=request.getParameter("code");
		String result="";
		HttpSession session=request.getSession();
		System.out.println(code);
		String value=(String)session.getAttribute("rand");
		code=code.toUpperCase();
		System.out.println(code);
		System.out.println(value);
		if (!code.equals(value)) {
			result="<font color='red'>ÑéÖ¤Âë´íÎó</font>";
			result+="<script type='text/javascript'> $('#btns').attr('disabled',true);  $('#btns').css('background','grey');</script>";
		}else {
			result+="<script type='text/javascript'> $('#btns').attr('disabled',false);  $('#btns').css('background','green');</script>";
		}
		 response.setContentType("text/html;charset=UTF-8");
		 response.getWriter().print(result);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
