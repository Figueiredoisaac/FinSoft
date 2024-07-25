package figueiredoisaac.finsoft.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    private String description;
    private Double value;
    private LocalDate receivedAt;
    private Boolean fixed;
    private String paymentType;
}
