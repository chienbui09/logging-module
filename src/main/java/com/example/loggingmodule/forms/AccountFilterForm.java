package com.example.loggingmodule.forms;


import com.example.loggingmodule.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountFilterForm {
    private String search;
    private Integer minId;
    private Integer maxId;
    private Account.Role role;
}
