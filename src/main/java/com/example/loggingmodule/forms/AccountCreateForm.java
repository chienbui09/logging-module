package com.example.loggingmodule.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AccountCreateForm {
    @NotBlank(message = "")
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private Integer departmentId;
}
