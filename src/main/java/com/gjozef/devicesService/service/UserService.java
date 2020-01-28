package com.gjozef.devicesService.service;

import com.gjozef.devicesService.domain.User;
import com.gjozef.devicesService.dto.UserListDTO;
import com.gjozef.devicesService.dto.request.UserRequestDTO;
import com.gjozef.devicesService.dto.response.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String userName);

    UserDTO saveUser(UserRequestDTO userRequest);

    UserDTO getUser(Long userId);

    UserListDTO getAllUsers();

    void deleteUser(Long userId);

    void editUser(Long userId, UserRequestDTO userRequest);
}
