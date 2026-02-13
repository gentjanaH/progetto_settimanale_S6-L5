package gentjanahani.progettou2w6d5.controllers;

import gentjanahani.progettou2w6d5.entities.Prenotazione;
import gentjanahani.progettou2w6d5.exceptions.ValidationException;
import gentjanahani.progettou2w6d5.payloads.PrenotazioneDTO;
import gentjanahani.progettou2w6d5.services.DipendenteService;
import gentjanahani.progettou2w6d5.services.PrenotazioneService;
import gentjanahani.progettou2w6d5.services.ViaggioService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;
    private final ViaggioService viaggioService;
    private final DipendenteService dipendenteService;

    public PrenotazioneController(PrenotazioneService prenotazioneService, ViaggioService viaggioService, DipendenteService dipendenteService) {
        this.prenotazioneService = prenotazioneService;
        this.viaggioService = viaggioService;
        this.dipendenteService = dipendenteService;
    }


    // 1. POST http://localhost:3025/prenotazioni (+ Payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione createPrenotazione(@RequestBody @Validated PrenotazioneDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();

            throw new ValidationException(errorsList);
        } else {
            return this.prenotazioneService.save(payload);
        }

    }
}
