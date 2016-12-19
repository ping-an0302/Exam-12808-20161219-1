package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.bean.Film;
import com.hand.common.factory.ConnectionFactory;

public class FilmDao {

	/* 
	 *  查询总共多少条数据
	 */
	public int findcount() {
		Connection conn = new ConnectionFactory().getconn();
		String sql = "select * from film";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int size = 0;
			try {
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				rs.last();
				size = rs.getRow();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return size;
	}
	
	/**
	 * 查询所有的film信息
	 */
	public List<Film> find(int curPage){
		List<Film> list = new ArrayList<Film>();
		
		Connection conn = new ConnectionFactory().getconn();
		String sql = "select film_id,title,description,name from film,language where film.language_id = language.language_id and film_id limit ?,10;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, curPage);
			rs = ps.executeQuery();
			while(rs.next()){
				//封装数据
				Film film = new Film();
				film.setFilm_id(rs.getLong("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguageName(rs.getString("name"));
				//将film模型放到list集合中
				list.add(film);
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
	
	/**
	 * 插入一条新的film信息
	 */
	public void insert(Film film){
		Connection conn = new ConnectionFactory().getconn();
		String sql = "insert into film(title,description,language_id) values(?,?,?)";
		PreparedStatement ps = null;
		try {
			
			ps = conn.prepareStatement(sql);
			//赋值
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setLong(3, film.getLanguage_id());
			ps.execute();
			
			//工厂中提供的链接对象设置了需要手动提交sql
			conn.commit();
			
		} catch (SQLException e) {
			try {
				//新增异常时进行回滚
				conn.rollback();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
