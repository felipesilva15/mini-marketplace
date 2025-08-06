package io.github.felipesilva15.marketplace.stock.repository;

import io.github.felipesilva15.marketplace.stock.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
