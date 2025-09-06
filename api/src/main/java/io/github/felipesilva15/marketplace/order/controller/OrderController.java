package io.github.felipesilva15.marketplace.order.controller;

import io.github.felipesilva15.marketplace.order.dto.OrderDTO;
import io.github.felipesilva15.marketplace.order.dto.OrderResponse;
import io.github.felipesilva15.marketplace.order.mapper.OrderMapper;
import io.github.felipesilva15.marketplace.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<OrderDTO> orderDTOs = orderService.findAll();
        List<OrderResponse> response = orderMapper.toResponseList(orderDTOs);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        OrderDTO orderDTO = orderService.findById(id);
        OrderResponse response = orderMapper.toResponse(orderDTO);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
