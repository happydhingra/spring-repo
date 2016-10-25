package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import repository.CustomerRepository;

import hello.Customer;

@Service
public class BookServiceImpl implements BookService{

	 @Autowired(required = true)
	    CustomerRepository customerRepository;
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return customer;
	}

	 @Override
	 @HystrixCommand(fallbackMethod = "defaultFindById")
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id);
	}

	 @Override
	 @HystrixCommand(fallbackMethod = "defaultFindById")
	public Customer checkDashBoard(int id) {
		 throw new RuntimeException();
	}
	 
	 public Customer defaultFindById(int id) {
		 Customer customer=new Customer();
		 customer.setId(id);
		 customer.setFirstName("Default");
		 customer.setLastName("Default");
	        return customer;
	    }

	@Override
	public List<Customer> getCustomerByName(String name) {
		return customerRepository.findByFirstName(name);
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepository.delete(id);
		
	}

	
}
