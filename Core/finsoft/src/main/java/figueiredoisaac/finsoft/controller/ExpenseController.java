package figueiredoisaac.finsoft.controller;

import figueiredoisaac.finsoft.models.Expense;
import figueiredoisaac.finsoft.services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> findAll() {
        return expenseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Expense> findById(@PathVariable Long id) {
        return expenseService.findById(id);
    }

    @PostMapping
    public Expense save(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        expenseService.deleteById(id);
    }
}
