package com.hand.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hand.bean.Customer;
import com.hand.bean.CustomerMapper;

public class CustomerDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> getCustomer(){
		String sql = "select * from customer";
		List<Customer> list = jdbcTemplate.query(sql, new CustomerMapper());
		return list;
	}
}
