package com.example.loggingmodule.service.impl;

import com.example.loggingmodule.entity.Account;
import com.example.loggingmodule.entity.Department;
import com.example.loggingmodule.forms.DepartmentCreateForm;
import com.example.loggingmodule.forms.DepartmentFilterForm;
import com.example.loggingmodule.forms.DepartmentUpdateForm;
import com.example.loggingmodule.repository.IDepartmentRepository;
import com.example.loggingmodule.service.IDepartmentService;
import com.example.loggingmodule.specification.DepartmentSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository repository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public Page<Department> findAll(Pageable pageable, DepartmentFilterForm form) {
        Specification<Department> spec = DepartmentSpecification.buildSpec(form);
        return repository.findAll(spec,pageable);
    }

    @Override
    public Department findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional // đồng bộ thêm tất cả, fail thì loại bỏ tất cả
    public void create(DepartmentCreateForm form) {
        Department department = mapper.map(form, Department.class);
        List<Account> accounts = department.getAccounts();
        if(accounts != null){
            for (Account account:
                 accounts) {
                account.setDepartment(department);
            }
        }
        repository.save(department);
    }

    @Override
    public void update(DepartmentUpdateForm form) {
        Department department = mapper.map(form, Department.class);
        repository.save(department);
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
