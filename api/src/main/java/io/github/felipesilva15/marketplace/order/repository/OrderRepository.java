package io.github.felipesilva15.marketplace.order.repository;

import io.github.felipesilva15.marketplace.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
