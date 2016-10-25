package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.validator.CustomerValidator;
import service.BookService;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class CustomerController {

	private List<Customer> customers;

	@Autowired
	private CustomerValidator customerValidator;
	
	@Autowired
	private BookService bookService;

	public CustomerController() {
		customers = new LinkedList<>();
		customers.add(new Customer(1, "Peter", "Test"));
		customers.add(new Customer(2, "Peter", "Test2"));
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return ResponseEntity.ok(bookService.getCustomerById(id));

	}

	@RequestMapping(value = "/exc/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Customer> testDashboard(@PathVariable int id) {
		return ResponseEntity.ok(bookService.checkDashBoard(id));

	}
	
	@RequestMapping(value = "/customerByName/{name}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name) {
		return ResponseEntity.ok(bookService.getCustomerByName(name));

	}

	@RequestMapping(value = "/updateCust", method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,BindingResult errors) {
		customerValidator.validate(customer, errors);
		return ResponseEntity.ok(bookService.save(customer));

	}
	

	@RequestMapping(value = "/deleteCust/{id}", method = RequestMethod.POST)
	public void deleteCustomer(@PathVariable int id) {
		bookService.deleteCustomer(id);
	}

}