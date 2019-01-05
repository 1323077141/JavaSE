package com.atguigu.mvcapp.test;


import java.util.List;
import com.atguigu.mvcapp.dao.CriteriaCustomer;
import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.atguigu.mvcapp.domain.Customer;
import org.junit.jupiter.api.Test;

public class CustomerDAPJdbcImplTest {
	
	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	
	@Test
	public void testgetForListWithCriteriaCustomer(){
		CriteriaCustomer cc = new CriteriaCustomer("k", null, null);
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		System.out.println(customers);
	}
	
	@Test
	public void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
		
	}

	@Test
	public void testSave() {
		Customer customer = new Customer();
		customer.setAddress("ShangHai");
		customer.setName("Jerry");
		customer.setPhone("13720998654");
		
		customerDAO.save(customer);
	}

	@Test
	public void testGetInteger() {
		Customer cust = customerDAO.get(1);
		System.out.println(cust);
	}

	@Test
	public void testDelete() {
		customerDAO.delete(2);
	}

	@Test
	public void testGetCountWithName() {
		long count = customerDAO.getCountWithName("Mike");
		System.out.println(count);
	}

}
