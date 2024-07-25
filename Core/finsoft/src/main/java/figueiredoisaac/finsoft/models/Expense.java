package figueiredoisaac.finsoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    private String description;
    private Double totalValue;
    private LocalDate dueDate;
    private Boolean fixed;
    private Boolean singleInstallment;
    private Integer numberOfInstallments;
    private Integer currentInstallment;
    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "despesa_pai_id")
    private Expense parentExpense;
}