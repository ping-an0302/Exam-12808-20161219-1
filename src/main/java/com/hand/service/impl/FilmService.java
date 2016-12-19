package com.hand.service.impl;

import java.util.List;

import com.hand.bean.Film;
import com.hand.dao.FilmDao;
import com.hand.service.IFilmService;

public class FilmService implements IFilmService{

	/* 
	 * 查询所有的film信息
	 */
	@Override
	public List<Film> find(int curPage) {
		FilmDao filmDao = new FilmDao();
		List<Film> list = filmDao.find(curPage);
		return list;
	}

	/* 
	 *  插入一条新的film信息
	 */
	@Override
	public void insert(Film film) {
		FilmDao filmDao = new FilmDao();
		filmDao.insert(film);
	}

	/* 
	 *  查询所有的数据
	 */
	@Override
	public int findcount() {
		FilmDao filmDao = new FilmDao();
		int i = filmDao.findcount();
		return i;
	}

	
	
}
