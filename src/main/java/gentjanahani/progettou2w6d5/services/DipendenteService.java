package gentjanahani.progettou2w6d5.services;

import gentjanahani.progettou2w6d5.entities.Dipendente;
import gentjanahani.progettou2w6d5.payloads.DipendenteDTO;
import gentjanahani.progettou2w6d5.repository.DipendenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;

    @Autowired
    public DipendenteService(DipendenteRepository dipendenteRepository) {
        this.dipendenteRepository = dipendenteRepository;
    }

    public Dipendente(DipendenteDTO payload) {
        
    }
}
