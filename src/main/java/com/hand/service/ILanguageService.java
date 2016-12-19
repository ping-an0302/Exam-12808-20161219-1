package com.hand.service;

import java.util.List;

import com.hand.bean.Language;

public interface ILanguageService {

	//查询所有的语言种类
	List<Language> find();

}
