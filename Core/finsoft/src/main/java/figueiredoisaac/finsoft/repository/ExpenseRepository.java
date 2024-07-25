package figueiredoisaac.finsoft.repository;

import figueiredoisaac.finsoft.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}