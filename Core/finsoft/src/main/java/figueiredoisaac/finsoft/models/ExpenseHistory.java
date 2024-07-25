package figueiredoisaac.finsoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class ExpenseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "despesa_id")
    private Expense expense;

    private Double value;
    private LocalDate dueDate;
    private LocalDate modificationDate;
    private Double interest;
    private Double fine;
    private Double increases;
    private Double decreases;
}
