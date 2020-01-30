package com.gjozef.devicesservice.service;

import com.gjozef.devicesservice.domain.User;
import com.gjozef.devicesservice.dto.request.UserRequestDTO;
import com.gjozef.devicesservice.dto.response.UserDTO;
import com.gjozef.devicesservice.dto.response.UserListDTO;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String userName);

    UserDTO saveUser(UserRequestDTO userRequest);

    UserDTO getUser(Long userId);

    UserListDTO getAllUsers();

    void deleteUser(Long userId);

    void editUser(Long userId, UserRequestDTO userRequest);
}
