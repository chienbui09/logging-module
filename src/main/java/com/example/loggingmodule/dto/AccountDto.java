package com.example.loggingmodule.dto;

import com.example.loggingmodule.common.CommonConfig;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String departmentName;

    @JsonFormat(pattern = CommonConfig.LOCALE_DATE_TIME_FORMAT)
    private LocalDateTime createdAt;
}
