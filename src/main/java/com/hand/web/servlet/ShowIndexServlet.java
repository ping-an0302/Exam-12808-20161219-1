package com.hand.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.bean.Film;
import com.hand.service.impl.FilmService;

/**
 * Servlet implementation class ShowIndexServlet
 */
public class ShowIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//实现分页功能 
		String tmp = request.getParameter("curPage");
		if(tmp==null){
		       tmp="0";
		}
		// 计数器
		int curPage = Integer.parseInt(tmp);
		
		HttpSession session = request.getSession();
		FilmService service = new  FilmService();
		
		//在传入值时将curPage扩大十倍
		List<Film> list = service.find(curPage*10);
		
		//将所有数据工可以分成几页
		int size = service.findcount();
		int pageCount = (size%10==0)?(size/10):(size/10+1);
		
		session.setAttribute("filmlist", list);
		session.setAttribute("curPage", curPage);
		session.setAttribute("pageCount", pageCount);
		response.sendRedirect("showindex.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
