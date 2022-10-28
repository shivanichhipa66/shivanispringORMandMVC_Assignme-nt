package com.shivani.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.shivani.customer.entity.Customer;
import com.shivani.customer.services.CustomerService;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//add mapping for "/list"
	
	@RequestMapping("/list")
  public String listcustomer(Model theModel) {
		
		System.out.println("request recieved");
		
		List<Customer> theCustomer = customerService.findAll();
		
		
		theModel.addAttribute("Student", theCustomer);
		
		return "list-customer";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer =new Customer();
		
		theModel.addAttribute("Customer",theCustomer);
		
		return "Customer-form";
	}
	
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCustomer =customerService.findbyId(theId);
		
		theModel.addAttribute ("Customer", theCustomer);
		
		return "Customer-form";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@RequestParam("id")int id,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email)
	
	{	System.out.println(id);
	Customer theCustomer;
	if(id!=0)
	{
		theCustomer = customerService.findbyId(id);
		theCustomer.setFirstName(firstName);
		theCustomer.setLastName(lastName);
		theCustomer.setEmail(email);
		
	}else
		theCustomer = new Customer(id, firstName,lastName,email);
	
	customerService.save(theCustomer);
		
	return "redirect:/customer/list";
}

	@RequestMapping("/delete")
	public String delete(@RequestParam("CustomerId")int theId) {
		
		customerService.deleteById(theId);
		
		return "redirect:/customer/list";
	}
}