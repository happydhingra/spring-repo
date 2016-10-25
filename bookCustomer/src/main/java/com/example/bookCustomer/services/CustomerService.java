package com.example.bookCustomer.services;

import com.example.bookCustomer.entity.CustomerEntity;
import com.example.bookCustomer.repository.CustomerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    @Autowired(required = true)
    CustomerRepository customerRepository;

    public List<CustomerEntity> byCustomer() {

        return customerRepository.findAll();
    }

    public CustomerEntity findByName(String name) {
        return customerRepository.findByName(name);
    }

    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id);
    }

    @HystrixCommand(fallbackMethod = "defaultFindById")
    public CustomerEntity findByIdExeption(Long id) {
        throw new RuntimeException("Unknown");

    }

    public CustomerEntity defaultFindById(Long id) {
        return new CustomerEntity(-1L, "Default", "Default");
    }

    public CustomerEntity saveCustomer(CustomerEntity ce) {

        return customerRepository.save(ce);
    }

    public void deleteCustomer(Long id) {
        customerRepository.delete(id);
    }
}
