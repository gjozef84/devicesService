package com.gjozef.devicesservice.service.impl;

import com.gjozef.devicesservice.assembler.UserDTOAssembler;
import com.gjozef.devicesservice.assembler.UserRequestAssembler;
import com.gjozef.devicesservice.domain.User;
import com.gjozef.devicesservice.dto.request.UserRequestDTO;
import com.gjozef.devicesservice.dto.response.UserDTO;
import com.gjozef.devicesservice.dto.response.UserListDTO;
import com.gjozef.devicesservice.exceptions.ResourceAlreadyExistsException;
import com.gjozef.devicesservice.exceptions.ResourceNotFoundException;
import com.gjozef.devicesservice.repository.UserRepository;
import com.gjozef.devicesservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDTOAssembler userDTOAssembler;
    private final UserRequestAssembler userRequestAssembler;

    @Override
    public Optional<User> findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public UserDTO saveUser(UserRequestDTO userRequest) {
        isExistsUserNameForSave(userRequest);
        isExistsEmailForSave(userRequest);
        User user = new User();
        userRequestAssembler.fillInDomain(userRequest, user);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        log.info("Saving user = {}", user);
        return userDTOAssembler.fromDomain(userRepository.save(user));
    }

    @Override
    public void editUser(Long userId, UserRequestDTO userRequest) {
        log.info("editUser() userId={} for userRequest={}", userId, userRequest);
        isExistsUserName(userRequest, userId);
        isExistsEmail(userRequest, userId);
        User user = fetchUser(userId);
        userRequestAssembler.fillInDomain(userRequest, user);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        userRepository.save(user);
    }

    @Override
    public UserDTO getUser(Long userId) {
        log.info("getUser() for userId={}", userId);
        return userDTOAssembler.fromDomain(fetchUser(userId));
    }

    @Override
    public UserListDTO getAllUsers() {
        log.info("getAllUsers()");
        List<User> users = userRepository.findAllByActiveTrue();
        if (CollectionUtils.isNotEmpty(users)) {
            return new UserListDTO(users.stream()
                .map(userDTOAssembler::fromDomain)
                .collect(Collectors.toList()));
        }
        return new UserListDTO();
    }

    @Override
    public void deleteUser(Long userId) {
        log.info("deleteUser() for userId={}", userId);
        User user = fetchUser(userId);
        user.setActive(false);
        userRepository.save(user);
    }

    private User fetchUser(Long userId) {
        return userRepository.findByIdAndActiveTrue(userId)
            .orElseThrow(() -> new ResourceNotFoundException(User.class, "id", userId.toString()));
    }

    private void isExistsEmail(UserRequestDTO userRequest, Long userId) {
        if (userRepository.existsByEmailAndIdIsNotAndActiveTrue(userRequest.getEmail(), userId)) {
            throw new ResourceAlreadyExistsException(User.class, "email", userRequest.getEmail());
        }
    }

    private void isExistsUserName(UserRequestDTO userRequest, Long userId) {
        if (userRepository.existsByUsernameAndIdIsNotAndActiveTrue(userRequest.getUserName(), userId)) {
            throw new ResourceAlreadyExistsException(User.class, "userName", userRequest.getUserName());
        }
    }

    private void isExistsEmailForSave(UserRequestDTO userRequest) {
        if (userRepository.existsByEmailAndActiveTrue(userRequest.getEmail())) {
            throw new ResourceAlreadyExistsException(User.class, "email", userRequest.getEmail());
        }
    }

    private void isExistsUserNameForSave(UserRequestDTO userRequest) {
        if (userRepository.existsByUsernameAndActiveTrue(userRequest.getUserName())) {
            throw new ResourceAlreadyExistsException(User.class, "userName", userRequest.getUserName());
        }
    }
}
