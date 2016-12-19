package com.hand.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.bean.Customer;
import com.hand.common.exception.CustomerException;
import com.hand.service.impl.CustomerService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		CustomerService cs = new CustomerService();
		try {
			Customer customer = cs.login(username, password);
			//登录成功，跳转成功页面
			session.setAttribute("customer", customer);
			response.sendRedirect("ShowIndexServlet");
		} catch (CustomerException e) {
			session.setAttribute("exception", e.getMessage());
			//密码如果一旦错误，则跳回原页面。
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
