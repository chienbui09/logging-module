package com.example.loggingmodule.forms;

import com.example.loggingmodule.common.ErrorMessage;
import com.example.loggingmodule.validation.UsernameNotExists;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
public class DepartmentCreateForm {
    private String name;


    private Integer totalMember;

    private String type;

    private List<@Valid Account> accounts;

    public static class Account{

        @NotBlank(message = ErrorMessage.ACCOUNT_NOT_BLANK)
        @Length(max = 50, message = ErrorMessage.ACCOUNT_NAME_LENGTH)
        @UsernameNotExists
        private String username;
    }
}
