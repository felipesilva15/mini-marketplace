package io.github.felipesilva15.marketplace.order.service;

import io.github.felipesilva15.marketplace.order.dto.OrderDTO;
import io.github.felipesilva15.marketplace.order.mapper.OrderMapper;
import io.github.felipesilva15.marketplace.order.model.Order;
import io.github.felipesilva15.marketplace.order.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();

        return orders
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));

        return orderMapper.toDTO(order);
    }

    @Transactional
    public OrderDTO create(Order order) {
        Order newOrder = orderRepository.save(order);

        return findById(newOrder.getId());
    }

    @Transactional
    public OrderDTO update(Long id, Order order) {
        OrderDTO existingOrder = findById(id);

        order.setId(existingOrder.getId());
        order.setCreatedAt(existingOrder.getCreatedAt());

        orderRepository.save(order);

        return findById(id);
    }

    @Transactional
    public void delete(Long id) {
        OrderDTO existingOrder = findById(id);
        orderRepository.deleteById(existingOrder.getId());
    }
}
