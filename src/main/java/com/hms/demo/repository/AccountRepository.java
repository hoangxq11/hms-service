package com.hms.demo.repository;

import com.hms.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    Optional<Account> findOneByEmail(String email);

    Optional<Account> findOneByUsername(String username);

    Boolean existsByUsernameOrEmail(String username, String email);
}
