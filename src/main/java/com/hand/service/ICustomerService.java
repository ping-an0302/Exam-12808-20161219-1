package com.hand.service;

import com.hand.bean.Customer;
import com.hand.common.exception.CustomerException;

public interface ICustomerService {

	//登录
	Customer login(String name,String password)throws CustomerException;
	//修改
	void updateUser(Customer customer)throws CustomerException;

}
