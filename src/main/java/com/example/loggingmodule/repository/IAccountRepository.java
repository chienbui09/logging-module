package com.example.loggingmodule.repository;

import com.example.loggingmodule.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer>, JpaSpecificationExecutor<Account> {
    boolean existsByUsername(String username);

    Account findByUsername(String username);
}
