package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.Customer;
import com.hand.common.factory.ConnectionFactory;

public class CustomerDao {

	
	public Customer findByName(String username){
		Customer customer = new Customer();
		
		Connection conn = new ConnectionFactory().getconn();	
		String sql = "select * from customer where first_name = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			//如果有返回集则进行封装
			if(rs.next()){
				customer.setCustomer_id(rs.getLong("customer_id"));
				customer.setStore_id(rs.getLong("store_id"));
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress_id(rs.getLong("address_id"));
				customer.setActive(rs.getByte("active"));
				customer.setCreate_date(rs.getDate("create_date"));
				customer.setLast_update(rs.getDate("last_update"));
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
		return customer;
	}
}
