package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.bean.Film;
import com.hand.bean.Language;
import com.hand.common.factory.ConnectionFactory;

public class LanguageDao {

	
	
	public List<Language> find() {
		List<Language> list = new ArrayList<Language>();
		
		Connection conn = new ConnectionFactory().getconn();
		String sql = "select language_id,name from language";
		PreparedStatement ps = null;
		ResultSet rs = null;
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					//封装数据
					Language language = new Language();
					//在新增时需要语言的id
					language.setLanguage_id(rs.getLong("language_id"));
					language.setName(rs.getString("name"));
					list.add(language);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					if(rs!=null)rs.close();
					if(ps!=null)ps.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		return list;
		}
	
}
		
	
		

