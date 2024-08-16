package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.entity1.Customer;

public interface CustomerService {
	String insertCustomer(Customer customer);
	
	List<Customer> getCustomerList();
	
	Customer getCustomerById(int id);
	
	String customerUpdate(Customer customer);
	
	String customerdeleteById(int id);
	
	String insertMultipleCustomer(List<Customer> customers);
	
	List<Customer> getCustomerByFirstName(String firstName);
	
}
