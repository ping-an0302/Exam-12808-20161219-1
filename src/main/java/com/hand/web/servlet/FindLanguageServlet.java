package com.hand.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.bean.Language;
import com.hand.service.impl.LanguageService;

/**
 * Servlet implementation class FindLanguageServlet
 */
public class FindLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Language> list = new LanguageService().find();
		HttpSession session = request.getSession();
		session.setAttribute("languagelist", list);
		//查到电影语言之后成功跳转到新增页面
		response.sendRedirect("insertfilm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
