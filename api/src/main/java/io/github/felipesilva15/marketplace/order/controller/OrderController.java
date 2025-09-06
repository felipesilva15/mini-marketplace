package io.github.felipesilva15.marketplace.order.controller;

import io.github.felipesilva15.marketplace.order.dto.OrderDTO;
import io.github.felipesilva15.marketplace.order.dto.OrderRequest;
import io.github.felipesilva15.marketplace.order.dto.OrderResponse;
import io.github.felipesilva15.marketplace.order.mapper.OrderMapper;
import io.github.felipesilva15.marketplace.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<OrderResponse> save(@Valid @RequestBody OrderRequest request){
        OrderDTO data = orderMapper.toDTO(request);
        OrderDTO orderDTO = orderService.create(data);
        OrderResponse response = orderMapper.toResponse(orderDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> update(@PathVariable Long id, @Valid @RequestBody OrderRequest request){
        OrderDTO data = orderMapper.toDTO(request);
        OrderDTO orderDTO = orderService.update(id, data);
        OrderResponse response = orderMapper.toResponse(orderDTO);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponse> delete(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
