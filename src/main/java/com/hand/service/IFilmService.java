package com.hand.service;

import java.util.List;

import com.hand.bean.Film;

public interface IFilmService {

	//查询所有的电影信息
	List<Film> find(int curPage);
	//插入一条电影信息
	void insert(Film film);
	//查询总共多少条数据
	int findcount();
	
}
