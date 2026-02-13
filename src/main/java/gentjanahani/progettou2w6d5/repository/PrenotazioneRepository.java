package gentjanahani.progettou2w6d5.repository;

import gentjanahani.progettou2w6d5.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    Prenotazione findByIdPrenotazione(UUID idPrenotazione);
}
