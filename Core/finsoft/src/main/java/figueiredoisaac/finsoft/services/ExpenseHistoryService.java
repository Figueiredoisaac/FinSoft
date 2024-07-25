package figueiredoisaac.finsoft.services;

import figueiredoisaac.finsoft.models.ExpenseHistory;
import figueiredoisaac.finsoft.repository.ExpenseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseHistoryService {

    private final ExpenseHistoryRepository expenseHistoryRepository;

    public ExpenseHistoryService(ExpenseHistoryRepository expenseHistoryRepository) {
        this.expenseHistoryRepository = expenseHistoryRepository;
    }

    public List<ExpenseHistory> findAll() {
        return expenseHistoryRepository.findAll();
    }

    public Optional<ExpenseHistory> findById(Long id) {
        return expenseHistoryRepository.findById(id);
    }

    public ExpenseHistory save(ExpenseHistory expenseHistory) {
        return expenseHistoryRepository.save(expenseHistory);
    }

    public void deleteById(Long id) {
        expenseHistoryRepository.deleteById(id);
    }
}
