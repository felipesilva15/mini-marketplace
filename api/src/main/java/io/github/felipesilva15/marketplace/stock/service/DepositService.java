package io.github.felipesilva15.marketplace.stock.service;

import io.github.felipesilva15.marketplace.stock.model.Deposit;
import io.github.felipesilva15.marketplace.stock.repository.DepositRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepositService {
    private final DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    @Transactional(readOnly = true)
    public List<Deposit> findAll() {
        return depositRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Deposit findById(Long id) {
        return depositRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Record not found."));
    }

    @Transactional
    public Deposit create(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Transactional
    public Deposit update(Long id, Deposit brand) {
        Deposit existingDeposit = findById(id);

        brand.setId(existingDeposit.getId());
        brand.setCreatedAt(existingDeposit.getCreatedAt());

        return depositRepository.save(brand);
    }

    @Transactional
    public void delete(Long id) {
        Deposit existingDeposit = findById(id);
        depositRepository.deleteById(existingDeposit.getId());
    }
}
