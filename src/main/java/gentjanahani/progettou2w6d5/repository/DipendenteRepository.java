package gentjanahani.progettou2w6d5.repository;

import gentjanahani.progettou2w6d5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, UUID> {

    Optional<Dipendente> findByEmail(String email);

    Optional<Dipendente> findByUsername(String username);

    Dipendente findByIdDipendente(UUID iaDipendente);
}
