package figueiredoisaac.finsoft.services;

import figueiredoisaac.finsoft.models.Income;
import figueiredoisaac.finsoft.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class IncomeService {

    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    public Optional<Income> findById(Long id) {
        return incomeRepository.findById(id);
    }

    public Income save(Income income) {
        return incomeRepository.save(income);
    }

    public void deleteById(Long id) {
        incomeRepository.deleteById(id);
    }
}

