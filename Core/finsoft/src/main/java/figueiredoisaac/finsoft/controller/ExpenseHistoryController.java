package figueiredoisaac.finsoft.controller;

import figueiredoisaac.finsoft.models.ExpenseHistory;
import figueiredoisaac.finsoft.services.ExpenseHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense-histories")
public class ExpenseHistoryController {

    private final ExpenseHistoryService expenseHistoryService;

    public ExpenseHistoryController(ExpenseHistoryService expenseHistoryService) {
        this.expenseHistoryService = expenseHistoryService;
    }

    @GetMapping
    public List<ExpenseHistory> findAll() {
        return expenseHistoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ExpenseHistory> findById(@PathVariable Long id) {
        return expenseHistoryService.findById(id);
    }

    @PostMapping
    public ExpenseHistory save(@RequestBody ExpenseHistory expenseHistory) {
        return expenseHistoryService.save(expenseHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        expenseHistoryService.deleteById(id);
    }
}
