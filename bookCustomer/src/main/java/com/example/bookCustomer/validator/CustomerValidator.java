package com.example.bookCustomer.validator;

import com.example.bookCustomer.entity.CustomerEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return CustomerEntity.class.isAssignableFrom(clazz);

    }

    public void validate(Object target, Errors errors) {
//         CustomerEntity detail = (CustomerEntity)target;
        ValidationUtils.rejectIfEmpty(errors, "name", "Name is requeired.");
        ValidationUtils.rejectIfEmpty(errors, "email", "Email is requeired.");
    }
}
