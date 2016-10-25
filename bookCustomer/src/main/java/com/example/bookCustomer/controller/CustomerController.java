package com.example.bookCustomer.controller;

import com.example.bookCustomer.entity.Customer;
import com.example.bookCustomer.entity.CustomerEntity;
import com.example.bookCustomer.services.ICustomerService;
import com.example.bookCustomer.validator.CustomerValidator;
import com.example.bookCustomer.RestFiegnClient;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

    protected static final Logger logger = Logger.getLogger(CustomerController.class
            .getName());
    
    @Autowired
    protected CustomerValidator customerValidator;

    @Autowired(required = true)
    protected ICustomerService cs;
    
    @Autowired(required = true)
    private RestFiegnClient restFiegnClient;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(customerValidator);
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> test(@PathVariable("id") int id) {
    	return ResponseEntity.ok(restFiegnClient.byName(id));
//        if(name.equals("byCustomer")){
//            System.out.println("restFiegnClient" + restFiegnClient.byCustomer());
//        }else if(name.equals("byName")){
//            System.out.println("restFiegnClient" + restFiegnClient.byName("name"));
//        }
//        else if(name.equals("byId")){
//            System.out.println("restFiegnClient" + restFiegnClient.byId("604"));
//        }else if(name.equals("deleteCustomer")){
//            restFiegnClient.deleteCustomer("604");
//        }
              
    }
    
    /*@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<CustomerEntity> byCustomer() {
        return cs.byCustomer();
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public CustomerEntity byName(@PathVariable("name") String name) {
       return cs.findByName(name);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public CustomerEntity byId(@PathVariable("id") String id) {
        System.out.println("byId >>>>byId >>>"+id);
        return cs.findById(Long.parseLong(id));
    }


    @RequestMapping(value = "/exe/{id}", method = RequestMethod.GET)
    public CustomerEntity byIdException(@PathVariable("id") String id) {
        return cs.findByIdExeption(Long.parseLong(id));
    }

    
    @RequestMapping(value = "/save/", method = RequestMethod.POST)
    public CustomerEntity saveCustomer(@RequestBody CustomerEntity cust, BindingResult errors) {
        System.out.println("CUSTOMER save>>>>>>>>>>: ");
        customerValidator.validate(logger, errors);
        if (!errors.hasErrors()) {
            return cs.saveCustomer(cust);
        } else {
            System.out.println("Validation failed.......");
            //TODO exception
            return null;
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void deleteCustomer(@PathVariable("id") String id) {
        cs.deleteCustomer(Long.parseLong(id));
    }*/
}
