package figueiredoisaac.finsoft.services;

import figueiredoisaac.finsoft.models.IncomeHistory;
import figueiredoisaac.finsoft.repository.IncomeHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeHistoryService {

    private final IncomeHistoryRepository incomeHistoryRepository;

    public IncomeHistoryService(IncomeHistoryRepository incomeHistoryRepository) {
        this.incomeHistoryRepository = incomeHistoryRepository;
    }

    public List<IncomeHistory> findAll() {
        return incomeHistoryRepository.findAll();
    }

    public Optional<IncomeHistory> findById(Long id) {
        return incomeHistoryRepository.findById(id);
    }

    public IncomeHistory save(IncomeHistory incomeHistory) {
        return incomeHistoryRepository.save(incomeHistory);
    }

    public void deleteById(Long id) {
        incomeHistoryRepository.deleteById(id);
    }
}
