package gentjanahani.progettou2w6d5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="prenotazioni")
public class Prenotazioni {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idPrenotazione;
    private LocalDate dataRichiesta;
    private String note;

    //relazione ManyToOne con viaggio

    //relazione ManyToOne con dipendente
}
