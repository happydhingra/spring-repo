package service;

import java.util.List;

import hello.Customer;

public interface BookService {
Customer save(Customer customer);
Customer update(Customer customer);
Customer getCustomerById(int id);
List<Customer> getCustomerByName(String id);
public void deleteCustomer(int id);
Customer checkDashBoard(int id);
}
