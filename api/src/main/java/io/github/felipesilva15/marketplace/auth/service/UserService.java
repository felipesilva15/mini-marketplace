package io.github.felipesilva15.marketplace.auth.service;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.auth.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, User user) {
        User existingUser = findById(id);

        user.setId(existingUser.getId());
        user.setCreatedAt(existingUser.getCreatedAt());

        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        User existingUser = findById(id);
        userRepository.deleteById(existingUser.getId());
    }
}
