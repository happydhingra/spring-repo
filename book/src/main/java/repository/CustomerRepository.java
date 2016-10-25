package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findByFirstName(String name);

	public Customer findById(int id);

}
