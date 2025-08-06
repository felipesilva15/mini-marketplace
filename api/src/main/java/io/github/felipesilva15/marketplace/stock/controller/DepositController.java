package io.github.felipesilva15.marketplace.stock.controller;

import io.github.felipesilva15.marketplace.stock.dto.DepositRequest;
import io.github.felipesilva15.marketplace.stock.dto.DepositResponse;
import io.github.felipesilva15.marketplace.stock.mapper.DepositMapper;
import io.github.felipesilva15.marketplace.stock.model.Deposit;
import io.github.felipesilva15.marketplace.stock.service.DepositService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposit")
public class DepositController {
    private final DepositService depositService;
    private final DepositMapper depositMapper;

    public DepositController(DepositService depositService, DepositMapper depositMapper) {
        this.depositService = depositService;
        this.depositMapper = depositMapper;
    }

    @GetMapping
    public ResponseEntity<List<DepositResponse>> findAll() {
        List<Deposit> deposits = depositService.findAll();
        List<DepositResponse> response = depositMapper.toResponseList(deposits);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepositResponse> findById(@PathVariable Long id) {
        Deposit deposit = depositService.findById(id);
        DepositResponse response = depositMapper.toResponse(deposit);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<DepositResponse> save(@Valid @RequestBody DepositRequest request){
        Deposit deposit = depositService.create(depositMapper.toModel(request));
        DepositResponse response = depositMapper.toResponse(deposit);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepositResponse> update(@PathVariable Long id, @Valid @RequestBody DepositRequest request){
        Deposit deposit = depositService.update(id, depositMapper.toModel(request));
        DepositResponse response = depositMapper.toResponse(deposit);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepositResponse> delete(@PathVariable Long id){
        depositService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
