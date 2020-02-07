package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.controller.swagger.UserControllerSwagger;
import com.gjozef.devicesservice.dto.request.UserRequestDTO;
import com.gjozef.devicesservice.dto.response.UserDTO;
import com.gjozef.devicesservice.dto.response.UserListDTO;
import com.gjozef.devicesservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements UserControllerSwagger {

    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserRequestDTO userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> editUser(@PathVariable("userId") Long userId, @RequestBody @Valid UserRequestDTO userRequest) {
        userService.editUser(userId, userRequest);
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<UserListDTO> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
