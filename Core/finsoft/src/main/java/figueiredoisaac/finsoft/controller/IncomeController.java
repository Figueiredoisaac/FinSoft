package figueiredoisaac.finsoft.controller;

import figueiredoisaac.finsoft.models.Income;
import figueiredoisaac.finsoft.services.IncomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incomes")
public class IncomeController {


    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping
    public List<Income> findAll() {
        return incomeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Income> findById(@PathVariable Long id) {
        return incomeService.findById(id);
    }

    @PostMapping
    public Income save(@RequestBody Income income) {
        return incomeService.save(income);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        incomeService.deleteById(id);
    }
}
