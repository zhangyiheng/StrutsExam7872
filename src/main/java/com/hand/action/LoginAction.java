package com.hand.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.bean.Customer;
import com.hand.dao.CustomerDao;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		String ret = ERROR;
		Connection conn = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			
			
			String Url="jdbc:mysql://localhost:3306/sakila";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(Url,"root","123456");
			String sql = "select * from customer";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<Customer> customers = new ArrayList<Customer>();
			HttpSession session = request.getSession();
			while(rs.next()){
				Customer customer = new Customer();
				System.out.println(rs.getString("first_name"));
				if(username.equals(rs.getString("first_name"))&&password.equals(rs.getString("last_name"))){
					ret=SUCCESS;
				}
				customer.setFirst_name(rs.getString("first_name"));
				customer.setLast_name(rs.getString("last_name"));
				customer.setAddress_id(rs.getInt("address_id"));
				customer.setEmail(rs.getString("email"));
				customer.setCustomer_id(rs.getInt("customer_id"));
				customer.setLast_update(rs.getDate("last_update"));
				
				customers.add(customer);
			}
			session.setAttribute("customers",customers);

			
		} catch (Exception e) {
			 ret = ERROR;
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					
				}
			}
		}
		return ret;
	}

	@Override
	public void validate() {
		if (username == null || username.trim().equals("")) {
			addFieldError("username", "用户不能为空");
		}
		if (password == null || password.trim().equals("")) {
			addFieldError("password", "密码不能为空");
		}
	}

//	public String check() {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"ApplicationContext.xml");
//
//		CustomerDao customerss = (CustomerDao) context.getBean("customer");
//		List<Customer> customers = customerss.getCustomer();
//		for (Customer customer : customers) {
//			if (customer.getFirst_name().equals(username)&&customer.getLast_name().equals(password)) {
//				
//				return SUCCESS;
//			}
//		}
//		return ERROR;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
