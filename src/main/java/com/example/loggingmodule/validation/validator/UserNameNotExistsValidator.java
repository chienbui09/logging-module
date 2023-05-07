package com.example.loggingmodule.validation.validator;


import com.example.loggingmodule.repository.IAccountRepository;
import com.example.loggingmodule.validation.UsernameNotExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameNotExistsValidator implements ConstraintValidator<UsernameNotExists,String> {

    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !accountRepository.existsByUsername(username);
    }
}
