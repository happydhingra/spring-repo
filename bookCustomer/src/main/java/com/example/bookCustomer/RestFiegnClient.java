package com.example.bookCustomer;

import com.example.bookCustomer.entity.Customer;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vinay.gupta
 */

@FeignClient(name = "google", url = "http://localhost:8090/books")
@RequestMapping("/")
public interface RestFiegnClient {

	 @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	    public Customer byName(@PathVariable("id") int id);

}
