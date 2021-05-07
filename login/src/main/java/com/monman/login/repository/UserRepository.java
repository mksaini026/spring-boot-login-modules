package com.monman.login.repository;

import com.monman.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM User u WHERE u.email = ?1", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "SELECT * FROM User u WHERE u.phone_number = ?1", nativeQuery = true)
    User findByMobile(String mobile);

    @Query(value = "SELECT * FROM User u WHERE u.email = ?1 or u.phone_number = ?1", nativeQuery = true)
    User findByEmailOrMobile(String username);
}
