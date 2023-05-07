package com.example.loggingmodule.forms;


import com.example.loggingmodule.entity.Department;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class DepartmentFilterForm {
    private String search;

    private Department.Type type;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime maxCreatedAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime minCreatedAt;
    private Integer minCreatedYear;
    private Integer createdYear;
}
