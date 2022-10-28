package com.shivani.customer.services;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import javax.websocket.Session;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.stereotype.Repository;
import com.shivani.customer.entity.Customer;



@Repository
public class CustomerServiceImpl implements CustomerService {

	private org.hibernate.Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory){
		try {
			session = sessionFactory.getCurrentSession();
		}catch(HibernateException e) {
			session =sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> findAll(){
		org.hibernate.Transaction tx = session.beginTransaction();

		List<Customer> customer=session.createQuery("from Customer").list();

		tx.commit();

		return customer;

	}

	@Transactional
	public Customer findById(int id) {

		Customer customer = new Customer();
		org.hibernate.Transaction tx = session.beginTransaction();

		customer = session.get(Customer.class, id);

		tx.commit();

		return customer;
	}

	@Transactional
	public void save(Customer theCustomer) {

		org.hibernate.Transaction tx = session.beginTransaction();

		session.saveOrUpdate(theCustomer);
		tx.commit();
	}

	@Transactional
	public void deleteById(int id) {

		org.hibernate.Transaction tx = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);

		session.delete(customer);

		tx.commit();
	}

	@Override
	public Customer findbyId(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

}




