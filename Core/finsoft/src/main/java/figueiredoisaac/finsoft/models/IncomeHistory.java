package figueiredoisaac.finsoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class IncomeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Income income;

    private Double value;
    private LocalDate receiptDate;
    private LocalDate modificationDate;
    private Double interest;
    private Double fine;
    private Double increases;
    private Double decreases;
}


