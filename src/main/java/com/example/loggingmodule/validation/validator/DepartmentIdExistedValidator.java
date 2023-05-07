package com.example.loggingmodule.validation.validator;

import com.example.loggingmodule.repository.IDepartmentRepository;
import com.example.loggingmodule.validation.DepartmentIdExisted;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentIdExistedValidator implements ConstraintValidator<DepartmentIdExisted,Integer> {
    @Autowired
    private IDepartmentRepository repository;
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsById(id);
    }
}
