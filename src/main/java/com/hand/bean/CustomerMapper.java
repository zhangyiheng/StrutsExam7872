package com.hand.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer>{

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setActive(rs.getInt("active"));
		customer.setAddress_id(rs.getInt("address_id"));
		customer.setCreate_date(rs.getDate("create_date"));
		customer.setCustomer_id(rs.getInt("customer_id"));
		customer.setEmail(rs.getString("email"));
		customer.setFirst_name(rs.getString("first_name"));
		customer.setLast_name(rs.getString("last_name"));
		customer.setLast_update(rs.getDate("last_update"));
		customer.setStore_id(rs.getInt("store_id"));
		return customer;
	}
	

}
