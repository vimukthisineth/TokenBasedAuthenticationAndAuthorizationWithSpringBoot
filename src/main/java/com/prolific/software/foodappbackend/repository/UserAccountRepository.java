package com.prolific.software.foodappbackend.repository;

import com.prolific.software.foodappbackend.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query("SELECT u FROM UserAccount u WHERE u.username = ?1")
    List<UserAccount> findByUsername(String username);

    @Query("SELECT u FROM UserAccount u WHERE u.token = ?1")
    List<UserAccount> findByToken(String token);
}
