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

    boolean existsByEmailAndActiveTrue(String email);

    boolean existsByUsernameAndActiveTrue(String userName);

    boolean existsByEmailAndIdIsNotAndActiveTrue(String email, Long userId);

    boolean existsByUsernameAndIdIsNotAndActiveTrue(String userName, Long userId);
}
