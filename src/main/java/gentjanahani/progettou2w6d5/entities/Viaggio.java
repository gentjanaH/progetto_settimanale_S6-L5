package gentjanahani.progettou2w6d5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="viaggio")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Viaggio {
    @Id@GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idViaggio;
    private String destination;
    private LocalDate travelDate;
    private boolean completed;

    public Viaggio(String destination, LocalDate travelDate) {
        this.destination = destination;
        this.travelDate = travelDate;
        this.completed =false;
    }
}
