package io.github.felipesilva15.marketplace.stock.controller;

import io.github.felipesilva15.marketplace.stock.dto.MovementRequest;
import io.github.felipesilva15.marketplace.stock.dto.MovementResponse;
import io.github.felipesilva15.marketplace.stock.mapper.MovementMapper;
import io.github.felipesilva15.marketplace.stock.model.Movement;
import io.github.felipesilva15.marketplace.stock.service.MovementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movement")
public class MovementController {
    private final MovementService movementService;
    private final MovementMapper movementMapper;

    public MovementController(MovementService movementService, MovementMapper movementMapper) {
        this.movementService = movementService;
        this.movementMapper = movementMapper;
    }

    @GetMapping
    public ResponseEntity<List<MovementResponse>> findAll() {
        List<Movement> movements = movementService.findAll();
        List<MovementResponse> response = movementMapper.toResponseList(movements);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementResponse> findById(@PathVariable Long id) {
        Movement movement = movementService.findById(id);
        MovementResponse response = movementMapper.toResponse(movement);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<MovementResponse> save(@Valid @RequestBody MovementRequest request){
        Movement movement = movementService.create(movementMapper.toModel(request));
        MovementResponse response = movementMapper.toResponse(movement);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementResponse> update(@PathVariable Long id, @Valid @RequestBody MovementRequest request){
        Movement movement = movementService.update(id, movementMapper.toModel(request));
        MovementResponse response = movementMapper.toResponse(movement);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovementResponse> delete(@PathVariable Long id){
        movementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
