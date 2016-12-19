package com.hand.service.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.bean.Customer;
import com.hand.common.exception.CustomerException;
import com.hand.dao.CustomerDao;
import com.hand.service.ICustomerService;

public class CustomerService implements ICustomerService{

	/**
	 * 登录
	 */
	@Override
	public Customer login(String username, String password) throws CustomerException {
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.findByName(username);

		if(customer.getCustomer_id()!=0){
			return customer;
		}else{
			 throw new CustomerException("密码不对。请重新输入！");
		}
	}

	@Override
	public void updateUser(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

}
