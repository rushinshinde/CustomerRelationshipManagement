package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity1.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
	@Override
	public String insertCustomer(Customer customer) {


		return customerDao.insertCustomer(customer);
	}
	@Override
	public List<Customer> getCustomerList()
	{
		List <Customer> list = customerDao.getCustomerList();
		return list;
	}
	@Override
	public Customer getCustomerById(int id) {

		Customer customer =  customerDao.getcustomerById(id);
		return customer;
	}
	
	@Override
	public String customerUpdate(Customer customer)
	{
		return customerDao.updateCustomer(customer);
	}
	
	@Override
	public String customerdeleteById(int id)
	{
		return customerDao.deleteCustomerById(id);	
	}

	@Override
	public String insertMultipleCustomer(List<Customer>customers)
	{
		return customerDao.insertMultipleCustomer(customers);	
	}

	@Override
	public List<Customer> getCustomerByFirstName(String fisrtName)
	{
		return customerDao.getCustomerByFirstName(fisrtName);	
	}
}
