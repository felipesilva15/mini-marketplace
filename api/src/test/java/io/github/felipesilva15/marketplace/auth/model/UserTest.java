package io.github.felipesilva15.marketplace.auth.model;

import io.github.felipesilva15.marketplace.common.model.BaseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User(
                1L,
                "User test",
                "user@test.com",
                "123456",
                "89831395875",
                Collections.emptyList()
        );
    }

    @Test
    @DisplayName("Should extends from BaseModel")
    void shouldExtendsFromBaseModel() {
        assertInstanceOf(BaseModel.class, user);
    }

    @Test
    @DisplayName("Should create user with correct data")
    void shouldCreateUserWithCorrectData() {
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("User test", user.getName());
        assertEquals("user@test.com", user.getEmail());
        assertEquals("123456", user.getPassword());
        assertEquals("89831395875", user.getDocument());
        assertEquals(Collections.emptyList(), user.getAddresses());
    }

    @Test
    @DisplayName("Should allow properties update")
    void shouldAllowPropertiesUpdate() {
        user.setName("new name");
        user.setEmail("new email");
        user.setPassword("new password");

        assertEquals("new name", user.getName());
        assertEquals("new email", user.getEmail());
        assertEquals("new password", user.getPassword());
    }

    @Test
    @DisplayName("Should get user authorities")
    void shouldGetAuthorities() {
        assertEquals(Collections.emptyList(), user.getAuthorities());
    }

    @Test
    @DisplayName("Should get username with same value of email")
    void shouldGetUsernameWithSameValueOfEmail() {
        assertEquals(user.getEmail(), user.getUsername());
    }

    @Test
    @DisplayName("Should return true for equal objects")
    void shouldReturnTrueForEqualObjects() {
        User secondUser = new User(
                1L,
                "User test",
                "user@test.com",
                "123456",
                "89831395875",
                Collections.emptyList()
        );

        assertEquals(user, secondUser);
        assertEquals(user, user);
    }

    @Test
    @DisplayName("Should return false for different objects")
    void shouldReturnFalseForDifferentObjects() {
        User secondUser = new User(
                2L,
                "User different test",
                "test@test.com",
                "12345",
                "44558899661",
                Collections.emptyList()
        );

        assertNotEquals(null, user);
        assertNotEquals(new Object(), user);
        assertNotEquals(secondUser, user);
    }

    @Test
    @DisplayName("Hash codes should be equal for equal objects")
    void hashCodesShouldBeEqualForEqualObjects() {
        User secondUser = new User(
                1L,
                "User test",
                "user@test.com",
                "123456",
                "89831395875",
                Collections.emptyList()
        );

        assertEquals(user.hashCode(), secondUser.hashCode());
    }

    @Test
    @DisplayName("Should create user with no args constructor")
    void shouldCreateUserWithNoArgsConstructor() {
        User testUser = new User();

        assertNotNull(testUser);
        assertNull(testUser.getId());
        assertNull(testUser.getName());
    }
}
