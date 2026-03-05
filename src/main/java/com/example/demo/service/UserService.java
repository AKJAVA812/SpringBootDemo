package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // FIX 4: Constructor injection instead of field injection
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        // FIX 5: Basic null-check before saving
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("User email must not be null or empty");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        // FIX 6: Throw a meaningful exception instead of silently returning null
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        existing.setUserName(updatedUser.getUserName());
        existing.setEmail(updatedUser.getEmail());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByEmail(String email) {
        // FIX 7: Use the correctly named repository method
        return userRepository.findByEmail(email);
    }
}
