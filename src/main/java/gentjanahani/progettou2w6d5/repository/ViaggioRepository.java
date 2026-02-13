package gentjanahani.progettou2w6d5.repository;

import gentjanahani.progettou2w6d5.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, UUID> {
    Viaggio findByIdViaggio(UUID idViaggio);
}
