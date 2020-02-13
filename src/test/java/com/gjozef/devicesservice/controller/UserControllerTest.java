package com.gjozef.devicesservice.controller;

import com.gjozef.devicesservice.dto.request.UserRequestDTO;
import com.gjozef.devicesservice.dto.response.UserDTO;
import com.gjozef.devicesservice.dto.response.UserListDTO;
import com.gjozef.devicesservice.service.UserService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
    }

    @Test
    void testAddUser() {
        UserDTO result = mock(UserDTO.class);
        UserRequestDTO userRequest = mock(UserRequestDTO.class);
        when(userService.saveUser(userRequest)).thenReturn(result);

        final ResponseEntity<UserDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<UserDTO> actual = userController.addUser(userRequest);

        assertEquals(expected, actual);
        verify(userService).saveUser(any(UserRequestDTO.class));
    }

    @Test
    void testEditUser() {
        Long userId = RandomUtils.nextLong();

        UserDTO result = mock(UserDTO.class);
        UserRequestDTO userRequest = mock(UserRequestDTO.class);
        when(userService.getUser(userId)).thenReturn(result);

        final ResponseEntity<UserDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<UserDTO> actual = userController.editUser(userId, userRequest);

        assertEquals(expected, actual);
        verify(userService).editUser(anyLong(), any(UserRequestDTO.class));
    }

    @Test
    void testGetUser() {
        Long userId = RandomUtils.nextLong();

        UserDTO result = mock(UserDTO.class);
        when(userService.getUser(userId)).thenReturn(result);

        final ResponseEntity<UserDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<UserDTO> actual = userController.getUser(userId);

        assertEquals(expected, actual);
        verify(userService).getUser(anyLong());
    }

    @Test
    void testGetAllUsers() {
        UserListDTO result = mock(UserListDTO.class);
        when(userService.getAllUsers()).thenReturn(result);

        final ResponseEntity<UserListDTO> expected = new ResponseEntity<>(result, HttpStatus.OK);
        final ResponseEntity<UserListDTO> actual = userController.getAllUsers();

        assertEquals(expected, actual);
        verify(userService).getAllUsers();
    }

    @Test
    void testDeleteUser() {
        Long userId = RandomUtils.nextLong();

        final ResponseEntity<Void> expected = new ResponseEntity<>(HttpStatus.OK);
        final ResponseEntity<Void> actual = userController.deleteUser(userId);

        assertEquals(expected, actual);
        verify(userService).deleteUser(anyLong());
    }
}