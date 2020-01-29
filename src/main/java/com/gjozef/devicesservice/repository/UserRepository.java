package com.gjozef.devicesservice.repository;

import com.gjozef.devicesservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);

    List<User> findAllByActiveTrue();

    Optional<User> findByIdAndActiveTrue(Long userId);

    boolean existsByUsernameAndActiveTrue(String userName);

    boolean existsByEmailAndActiveTrue(String email);
}
