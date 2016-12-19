package com.hand.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.bean.Film;
import com.hand.service.impl.FilmService;

/**
 * Servlet implementation class InsertFilmServlet
 */
public class InsertFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Film film = new Film();
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));
		film.setLanguage_id(Long.parseLong(request.getParameter("language_id")));

		//调用service层
		new FilmService().insert(film);
		
		//新增数据完成后跳回ShowIndexServlet重新刷新一遍数据
		response.sendRedirect("ShowIndexServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
