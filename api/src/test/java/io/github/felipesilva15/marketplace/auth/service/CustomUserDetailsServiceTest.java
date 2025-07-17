package io.github.felipesilva15.marketplace.auth.service;

import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.auth.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User(
                1L,
                "User test",
                "user@test.com",
                "1234",
                "89831395875",
                Collections.emptyList()
        );
    }

    @Test
    @DisplayName("Should load user by username successfully")
    void shouldLoadUserByUsernameSuccessfully() {
        when(userRepository.findByEmail("user@test.com")).thenReturn(Optional.of(user));

        UserDetails userDetails = customUserDetailsService.loadUserByUsername("user@test.com");

        assertNotNull(userDetails);
        assertEquals(user.getEmail(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().isEmpty());
        verify(userRepository, times(1)).findByEmail("user@test.com");
    }

    @Test
    @DisplayName("Should throw UsernameNotFoundException when user does not exist")
    void shouldThrowUsernameNotFoundExceptionWhenUserDoesNotExist() {
        when(userRepository.findByEmail("invalid@test.com")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername("invalid@test.com"));
        verify(userRepository, times(1)).findByEmail("invalid@test.com");
    }
}
