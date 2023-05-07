package com.example.loggingmodule.service;

import com.example.loggingmodule.entity.Department;
import com.example.loggingmodule.forms.DepartmentCreateForm;
import com.example.loggingmodule.forms.DepartmentFilterForm;
import com.example.loggingmodule.forms.DepartmentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable, DepartmentFilterForm form);
    Department findById(int id);
    void create (DepartmentCreateForm form);
    void update (DepartmentUpdateForm form);
    void deleteById(int id);
    void deleteAllById(List<Integer> ids);
}
