package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity1.Customer;

@Repository
public class CustomerDao {

//	@Autowired
	SessionFactory sf;

	public CustomerDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	public String insertCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();//use transaction for Insert update delete
		session.save(customer);
		tr.commit();
		session.close();

		return "Customer Insert Succesfully";

	}
	public List<Customer> getCustomerList()
	{
		Session session = sf.openSession();
		return session.createQuery("from Customer").list();
	}
	public Customer getcustomerById(int Id) {
		Session session=sf.openSession();
		Customer customer = Session.load(Customer.class, id);
		return customer;
	}
	 
	public String updateCustomer(Customer customer) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(customer);
		tr.commit();
		session.close();
		
		return "customer updated succesfully";
		
	}
	
	public String deleteCustomerById(int id)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		session .delete(customer);
		tr.commit();
		session.close();
		
		
		return "customer delete succesfully";
		
	}
	
	public String insertMultipleCustomer(List<Customer> customers) {
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for(Customer customer : customers) 
		{
			session.save(customer);
		}
		tr.commit();
		session.close();
		 
		return "customer inserted succesfully";
	}
	
	public List <Customer> getCustomerByFirstName(String firstName)
	{
		 Session session = sf.openSession();
		 Query<Customer> customers = session.createQuery("from Customer c where c.firstName =:firstName", Customer.class);
		 customers.setParameter("firstName", firstName);
		 List<Customer> list = customers.list();
	}
}
