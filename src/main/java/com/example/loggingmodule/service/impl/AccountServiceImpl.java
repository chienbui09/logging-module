package com.example.loggingmodule.service.impl;

import com.example.loggingmodule.entity.Account;
import com.example.loggingmodule.forms.AccountCreateForm;
import com.example.loggingmodule.forms.AccountFilterForm;
import com.example.loggingmodule.forms.AccountUpdateForm;
import com.example.loggingmodule.repository.IAccountRepository;
import com.example.loggingmodule.service.IAccountService;
import com.example.loggingmodule.specification.AccountSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final ModelMapper mapper;
    private final IAccountRepository repository;
    private final PasswordEncoder encoder;
    @Override
    public Page<Account> findAll(Pageable pageable, AccountFilterForm form) {
        Specification<Account> spec = AccountSpecification.buildSpec(form);
        return repository.findAll(spec,pageable);
    }

    @Override
    public Account findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(AccountCreateForm form) {
        Account account = mapper.map(form, Account.class);
        String encodedPassword = encoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
        repository.save(account);
    }

    @Override
    public void update(AccountUpdateForm form) {
        Account account = mapper.map(form, Account.class);
        String encodedPassword = encoder.encode(form.getPassword());
        account.setPassword(encodedPassword);
        repository.save(account);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
