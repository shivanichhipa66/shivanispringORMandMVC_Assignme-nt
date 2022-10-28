package com.shivani.customer.entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="customer")
public class Customer {
//id(primary key,auto incremented)book, author,

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Customer() {
		
	}
	
	
	public Customer(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id="+id+", firstName="+firstName+",lastName="+lastName+", course="+email+" ]";
	}
}

