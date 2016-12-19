package com.hand.service.impl;

import java.util.List;

import com.hand.bean.Language;
import com.hand.dao.LanguageDao;
import com.hand.service.ILanguageService;

public class LanguageService implements ILanguageService{

	@Override
	public List<Language> find() {
		 LanguageDao languageDao = new LanguageDao();
		 List<Language> list = languageDao.find();
		return list;
	}


}
