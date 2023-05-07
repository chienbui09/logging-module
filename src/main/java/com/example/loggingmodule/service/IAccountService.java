package com.example.loggingmodule.service;

import com.example.loggingmodule.entity.Account;
import com.example.loggingmodule.forms.AccountCreateForm;
import com.example.loggingmodule.forms.AccountFilterForm;
import com.example.loggingmodule.forms.AccountUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<Account> findAll(Pageable pageable, AccountFilterForm form);
    Account findById(int id);
    void create (AccountCreateForm form);
    void update (AccountUpdateForm form);
    void deleteById(int id);
    void deleteAllById(List<Integer> ids);
}
