package com.shivani.customer.services;
import java.util.List;
import com.shivani.customer.entity.Customer;

public interface CustomerService {

	public Customer findbyId(int theId);

	public void deleteById(int theId);

	public void save( Customer thestudent);

	public  List<Customer> findAll();






}


