package com.example.loggingmodule.specification;

import com.example.loggingmodule.entity.Department;
import com.example.loggingmodule.forms.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DepartmentSpecification {
    public static Specification<Department> buildSpec(DepartmentFilterForm form){
        if(form == null){
            return null;
        }

        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(form.getSearch())){
                predicates.add(
                        criteriaBuilder.or(
                                criteriaBuilder.like(
                                        root.get("name"),
                                        "%" + form.getSearch() + "%"
                                )
                        )
                );
            }
            if (form.getType() != null){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("type"),
                                form.getType()
                        )
                );
            }
            if (form.getCreatedAt() != null){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("createdAt").as(LocalDateTime.class),
                                form.getCreatedAt()
                        )
                );
            }
            if (form.getMaxCreatedAt() != null){
                predicates.add(
                        criteriaBuilder.lessThanOrEqualTo(
                                root.get("createdAt").as(LocalDateTime.class),
                                form.getMaxCreatedAt()
                        )
                );
            }
            if (form.getMinCreatedAt() != null){
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(
                                root.get("createdAt").as(LocalDateTime.class),
                                form.getMinCreatedAt()
                        )
                );
            }
            if (form.getMinCreatedYear() != null){
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(
                                criteriaBuilder.function("YEAR", Integer.class, root.get("createdAt")),
                                form.getMinCreatedYear()
                        )
                );
            }
            if (form.getCreatedYear() != null){
                predicates.add(
                        criteriaBuilder.equal(
                                criteriaBuilder.function("YEAR", LocalDateTime.class,root.get("createdAt")),
                                form.getCreatedYear()
                        )
                );
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
