package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// FIX 14: Use MockitoExtension for a lightweight unit test (no full app context)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserById_notFound() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());
        Optional<User> result = userService.getUserById(99L);
        // FIX 15: Correct assertion — result should NOT be present
        assertFalse(result.isPresent());
    }
}
