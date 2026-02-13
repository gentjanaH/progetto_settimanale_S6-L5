package gentjanahani.progettou2w6d5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="dipendente")
@Getter
@Setter
@NoArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID idDipendente;
    private String username;
    private String name;
    private String surname;
    private String email;

    public Dipendente(String username, String name, String surname, String email) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

}
