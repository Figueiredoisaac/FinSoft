package figueiredoisaac.finsoft.controller;

import figueiredoisaac.finsoft.models.IncomeHistory;
import figueiredoisaac.finsoft.services.IncomeHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/income-histories")
public class IncomeHistoryController {

    private final IncomeHistoryService incomeHistoryService;

    public IncomeHistoryController(IncomeHistoryService incomeHistoryService) {
        this.incomeHistoryService = incomeHistoryService;
    }

    @GetMapping
    public List<IncomeHistory> findAll() {
        return incomeHistoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<IncomeHistory> findById(@PathVariable Long id) {
        return incomeHistoryService.findById(id);
    }

    @PostMapping
    public IncomeHistory save(@RequestBody IncomeHistory incomeHistory) {
        return incomeHistoryService.save(incomeHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        incomeHistoryService.deleteById(id);
    }
}