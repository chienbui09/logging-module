package com.example.loggingmodule.specification;

import com.example.loggingmodule.entity.Account;
import com.example.loggingmodule.forms.AccountFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class AccountSpecification {
    public static Specification<Account> buildSpec(AccountFilterForm form){
        if (form == null){
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
//            searchByUsername username LIKE '%search%'
            if (StringUtils.hasText(form.getSearch())){
                predicates.add(
                        criteriaBuilder.or(
                                criteriaBuilder.like(
                                        root.get("username"),
                                        "%" +form.getSearch() + "%"
                                ),
                                criteriaBuilder.like(
                                        root.get("firstName"),
                                        "%" +form.getSearch() + "%"
                                ),
                                criteriaBuilder.like(
                                        root.get("lastName"),
                                        "%" +form.getSearch() + "%"
                                )
                        )
                );
            }
            if (form.getMinId() != null){
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(
                                root.get("id"),
                                form.getMinId()
                        )
                );
            }
            if (form.getMaxId() != null){
                predicates.add(
                        criteriaBuilder.lessThanOrEqualTo(
                                root.get("id"),
                                form.getMaxId()
                        )
                );
            }
            if (form.getRole() != null){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("role"),
                                form.getRole()
                        )
                );
            }
            /*
            * searchByUserName
            * searchById
            * Where C1 and C2
            * builder.add chỉ nhận một mảng, không nhận list
            * ==> chuyển từ list sang mảng*/
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
