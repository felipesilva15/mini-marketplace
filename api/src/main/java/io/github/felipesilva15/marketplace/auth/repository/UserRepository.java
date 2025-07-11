package io.github.felipesilva15.marketplace.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.felipesilva15.marketplace.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
