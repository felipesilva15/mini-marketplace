package io.github.felipesilva15.marketplace.auth.repository;

import io.github.felipesilva15.marketplace.auth.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Shoul find an user by e-mail")
    void shouldFindUserByEmail() {
        User user = new User(
                null,
                "User test",
                "user@test.com",
                "123456",
                "89831395875",
                Collections.emptyList()
        );

        entityManager.persistAndFlush(user);

        Optional<User> foundUser = userRepository.findByEmail("user@test.com");

        assertTrue(foundUser.isPresent());
        assertEquals("User test", foundUser.get().getName());
        assertEquals("user@test.com", foundUser.get().getEmail());
    }

    @Test
    @DisplayName("Should not find user by non existent e-mail")
    void shouldNotFindUserByNonExistentEmail() {
        Optional<User> foundUser = userRepository.findByEmail("invalid.email@test.com");

        assertFalse(foundUser.isPresent());
    }

    @Test
    @DisplayName("Should save and retrieve user")
    void shouldSaveAndRetrieveUser() {
        User newUser = new User(
                null,
                "User test",
                "user@test.com",
                "123456",
                "89831395875",
                Collections.emptyList()
        );

        User savedUser = userRepository.save(newUser);

        assertNotNull(savedUser.getId());

        Optional<User> retrievedUser = userRepository.findById(savedUser.getId());

        assertTrue(retrievedUser.isPresent());
        assertEquals(savedUser.getId(), retrievedUser.get().getId());
        assertEquals("User test", retrievedUser.get().getName());
    }

    @Test
    @DisplayName("Should delete user")
    void shouldDeleteUser() {
        User userToDelete = new User(
                null,
                "User test",
                "user@test.com",
                "123456",
                "89831395875",
                Collections.emptyList()
        );
        entityManager.persistAndFlush(userToDelete);
        Long userId = userToDelete.getId();

        userRepository.deleteById(userId);

        Optional<User> foundUser = userRepository.findById(userId);
        assertFalse(foundUser.isPresent());
    }
}
