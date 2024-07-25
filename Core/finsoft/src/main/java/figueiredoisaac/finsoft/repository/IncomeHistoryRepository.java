package figueiredoisaac.finsoft.repository;

import figueiredoisaac.finsoft.models.IncomeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeHistoryRepository extends JpaRepository<IncomeHistory, Long> {
}