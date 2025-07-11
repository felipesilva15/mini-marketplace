package io.github.felipesilva15.marketplace.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.auth.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public User create(User user) {
        return repository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }
}
