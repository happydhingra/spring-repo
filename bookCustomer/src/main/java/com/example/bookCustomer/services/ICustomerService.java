package com.example.bookCustomer.services;

import com.example.bookCustomer.entity.CustomerEntity;
import java.util.List;


public interface ICustomerService {
    
  public List<CustomerEntity> byCustomer();
  public CustomerEntity findByName(String name);
  public CustomerEntity findById(Long id);
  public CustomerEntity saveCustomer(CustomerEntity ce);
  public void deleteCustomer(Long id);
  public CustomerEntity findByIdExeption(Long id);
}
