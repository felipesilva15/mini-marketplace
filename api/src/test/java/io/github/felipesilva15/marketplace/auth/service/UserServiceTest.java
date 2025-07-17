package io.github.felipesilva15.marketplace.auth.service;

import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.auth.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User userOne;
    private User userTwo;

    @BeforeEach
    void setUp() {
        userOne = new User(
                1L,
                "User test one",
                "user.one@test.com",
                "1234",
                "89831395875",
                Collections.emptyList()
        );
        userTwo = new User(
                2L,
                "User test two",
                "user.two@test.com",
                "4321",
                "10564455698",
                Collections.emptyList()
        );
    }

    @Test
    @DisplayName("Should retrieve all users")
    void shouldFindAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(userOne, userTwo));

        List<User> users = userService.findAll();

        assertNotNull(users);
        assertEquals(2, users.size());
        assertTrue(users.contains(userOne));
        assertTrue(users.contains(userTwo));
        verify(userRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should find user by ID when exists")
    void shouldFindUserByIdWhenExists() throws EntityNotFoundException {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userOne));

        User foundUser = userService.findById(1L);

        assertNotNull(foundUser);
        assertEquals(userOne.getId(), foundUser.getId());
        assertEquals(userOne.getName(), foundUser.getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when user does not exist by ID")
    void shouldThrowEntityNotFoundExceptionWhenUserDoesNotExistById() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.findById(99L));
        verify(userRepository, times(1)).findById(99L);
    }

    @Test
    @DisplayName("Should create a new user")
    void shouldCreateNewUser() {
        User newUser = new User(
                1L,
                "New user",
                "user.new@test.com",
                "123",
                "04899653801",
                Collections.emptyList()
        );
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User userToSave = invocation.getArgument(0);
            userToSave.setId(3L);
            return userToSave;
        });

        User createdUser = userService.create(newUser);

        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertEquals("New user", createdUser.getName());
        verify(userRepository, times(1)).save(newUser);
    }

    @Test
    @DisplayName("Should update existing user")
    void shouldUpdateExistingUser() throws EntityNotFoundException {
        User existingUser = new User(
                1L,
                "Original user",
                "user.original@test.com",
                "123",
                "04899653801",
                Collections.emptyList()
        );
        User updatedUserData = new User(
                1L,
                "Updated user",
                "user.updated@test.com",
                "123",
                "04899653801",
                Collections.emptyList()
        );

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User resultUser = userService.update(1L, updatedUserData);

        assertNotNull(resultUser);
        assertEquals(1L, resultUser.getId());
        assertEquals("Updated user", resultUser.getName());
        assertEquals("user.updated@test.com", resultUser.getEmail());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(updatedUserData);
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when updating non existent user ID")
    void shouldThrowEntityNotFoundExceptionWhenUpdatingNonExistentUser() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        User updatedUserData = new User(
                1L,
                "Updated user",
                "user.updated@test.com",
                "123",
                "04899653801",
                Collections.emptyList()
        );
        assertThrows(EntityNotFoundException.class, () -> userService.update(99L, updatedUserData));
        verify(userRepository, times(1)).findById(99L);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should delete user")
    void shouldDeleteUserSuccessfully() throws EntityNotFoundException {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userOne));

        userService.delete(1L);

        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when deleting non existent user ID")
    void shouldThrowEntityNotFoundExceptionWhenDeletingNonExistentUser() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> userService.delete(99L));
        verify(userRepository, times(1)).findById(99L);
        verify(userRepository, never()).deleteById(anyLong());
    }

    @Test
    @DisplayName("Should encode password when saving user")
    void shouldEncodePasswordWhenSavingUser() {
        User newUser = new User(
                null,
                "New user",
                "user.new@test.com",
                "rawPassword",
                "04899653801",
                Collections.emptyList()
        );

        when(passwordEncoder.encode("rawPassword")).thenReturn("encodedPassword");

        when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
            User userToSave = invocation.getArgument(0);
            assertEquals("encodedPassword", userToSave.getPassword());
            userToSave.setId(3L);
            return userToSave;
        });

        User createdUser = userService.create(newUser);

        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertEquals("New user", createdUser.getName());
        assertEquals("encodedPassword", createdUser.getPassword());

        verify(passwordEncoder, times(1)).encode("rawPassword");
        verify(userRepository, times(1)).save(newUser);
    }
}
