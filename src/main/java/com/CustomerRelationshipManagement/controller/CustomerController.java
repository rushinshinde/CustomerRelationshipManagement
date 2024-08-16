package com.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagement.entity1.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping("/insert")
	public String insertCustomer(@RequestBody Customer customer) {

		String msg = customerService.insertCustomer(customer);

		return msg;
	}
	
	public List<Customer> getCustomerList()
	{
		List<Customer> list = customerService.getCustomerList();
		return list;
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@PutMapping
	public String customerUpdate(@RequestBody Customer customer)
	{
		return customerService.customerUpdate(customer);
	}
	
	@DeleteMapping("/{id}")
	public String customerDeleteById(@PathVariable int id)
	{
		return customerService.customerdeleteById(id);
	}
	
	@PostMapping
	public String insertMultipleCustomer(@RequestBody List<Customer> customers)
	{
		return customerService.insertMultipleCustomer(customers);
	}
	
	@GetMapping("/byname/{name}")
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName)
	{
		return customerService.getCustomerByFirstName(firstName);
		 
	}
}

