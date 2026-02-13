package gentjanahani.progettou2w6d5.services;

import gentjanahani.progettou2w6d5.entities.Dipendente;
import gentjanahani.progettou2w6d5.exceptions.BadRequestException;
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

    public Dipendente save(DipendenteDTO payload) {

        this.dipendenteRepository.findByEmail(payload.mail()).ifPresent(dipentente -> {
            throw new BadRequestException("L'email " + dipentente.getEmail() + "  è già in uso!");
        });

        this.dipendenteRepository.findByUsername(payload.username()).ifPresent(dipentente -> {
            throw new BadRequestException("Lo username" + dipentente.getUsername() + "  è già in uso!");
        });

        Dipendente newDipendente = new Dipendente(payload.username(), payload.name(), payload.surname(), payload.mail());
        newDipendente.setAvatar("https://ui-avatars.com/api?name=" + payload.surname());

        Dipendente savedDip = this.dipendenteRepository.save(newDipendente);
        log.info("Il dipendente con id {} è stato salvato correttamente.", payload.surname());

        return savedDip;
    }
}
