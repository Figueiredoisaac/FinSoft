package figueiredoisaac.finsoft.repository;

import figueiredoisaac.finsoft.models.ExpenseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseHistoryRepository extends JpaRepository<ExpenseHistory, Long> {
}