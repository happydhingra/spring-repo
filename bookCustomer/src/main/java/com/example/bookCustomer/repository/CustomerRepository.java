package com.example.bookCustomer.repository;

import com.example.bookCustomer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vinay.gupta
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    public CustomerEntity findByName(String name);

    public CustomerEntity findById(Long id);

}
