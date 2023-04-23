package com.example.loggingmodule.dto;

import com.example.loggingmodule.common.CommonConfig;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DepartmentDto extends RepresentationModel<DepartmentDto> {
    private Integer id;
    private String name;
    private Integer totalMembers;
    private String type;

    @JsonFormat(pattern = CommonConfig.LOCALE_DATE_TIME_FORMAT)
    private LocalDateTime createdAt;

    @JsonFormat(pattern = CommonConfig.LOCALE_DATE_TIME_FORMAT)
    private LocalDateTime updatedAt;

    private List<AccountDto> accounts;


    @Getter
    @Setter
    public class AccountDto extends RepresentationModel<AccountDto>{
        private Integer id;
        private String username;
    }
}
