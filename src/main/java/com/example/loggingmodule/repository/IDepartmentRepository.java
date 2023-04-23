package com.example.loggingmodule.repository;

import com.example.loggingmodule.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Integer>, JpaSpecificationExecutor<Department> {

    boolean existsByName(String name);
}
