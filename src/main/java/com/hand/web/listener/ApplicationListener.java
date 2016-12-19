package com.hand.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hand.bean.Film;
import com.hand.service.impl.FilmService;

//此功能废弃

//检测服务器一旦启动，就从数据库将把所有电影信息拿出来拿出来，并且把所有数据放到application对象里
public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		//调用service层
		List<Film> list = new FilmService().find(0);
		application.setAttribute("list", list);
	}

}
