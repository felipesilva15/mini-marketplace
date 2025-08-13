package io.github.felipesilva15.marketplace.stock.repository;

import io.github.felipesilva15.marketplace.stock.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}
