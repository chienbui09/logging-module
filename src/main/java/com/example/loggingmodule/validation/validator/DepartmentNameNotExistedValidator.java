package com.example.loggingmodule.validation.validator;


import com.example.loggingmodule.repository.IDepartmentRepository;
import com.example.loggingmodule.validation.DepartmentNameNotExisted;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentNameNotExistedValidator implements ConstraintValidator<DepartmentNameNotExisted,String> {

    @Autowired
    private IDepartmentRepository repository;
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByName(name);
    }
}
