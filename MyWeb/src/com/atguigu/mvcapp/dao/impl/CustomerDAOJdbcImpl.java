package com.atguigu.mvcapp.dao.impl;

import java.util.List;

import com.atguigu.mvcapp.dao.CriteriaCustomer;
import com.atguigu.mvcapp.dao.CustomerDAO;
import com.atguigu.mvcapp.dao.DAO;
import com.atguigu.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO{

	@Override
	public List<Customer> getAll() {
		String sql = "SELECT id, name, address, phone FROM Customers";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO Customers(name, address, phone) VALUES(?,?,?)";
		
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id, name, address, phone FROM Customers WHERE id = ?";
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM Customers WHERE id = ?";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql = "SELECT count(id) FROM Customers WHERE name = ?";
		return getForValue(sql, name);
	}

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		String sql = "SELECT id, name, address, phone FROM customers WHERE " +
				"name LIKE ? AND address LIKE ? AND phone LIKE ?";
		return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());
	}

	@Override
	public void update(Customer customer) {
		String sql = "UPDATE customers SET name = ?, address = ?, phone = ? "
				+ "WHERE id = ? ";
		update(sql, customer.getName(), customer.getAddress(), 
				customer.getPhone(), customer.getId());
	}

}
