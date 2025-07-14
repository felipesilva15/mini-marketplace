package io.github.felipesilva15.marketplace.auth.service;

import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.auth.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
    }

    @Transactional
    public User create(User user) {
        encodePassword(user);

        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, User user) {
        User existingUser = findById(id);

        user.setId(existingUser.getId());
        user.setCreatedAt(existingUser.getCreatedAt());
        encodePassword(user);

        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        User existingUser = findById(id);
        userRepository.deleteById(existingUser.getId());
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}
