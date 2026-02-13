package gentjanahani.progettou2w6d5.controllers;

import gentjanahani.progettou2w6d5.entities.Dipendente;
import gentjanahani.progettou2w6d5.exceptions.ValidationException;
import gentjanahani.progettou2w6d5.payloads.DipendenteDTO;
import gentjanahani.progettou2w6d5.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    private final DipendenteService dipendenteService;

    @Autowired
    public DipendenteController(DipendenteService dipendenteService) {
        this.dipendenteService = dipendenteService;
    }

    // 1. POST http://localhost:3025/dipendenti (+ Payload)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente createViaggio(@RequestBody @Validated DipendenteDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            List<String> errorsList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();

            throw new ValidationException(errorsList);
        } else {
            return this.dipendenteService.save(payload);
        }
    }

    // 2. PATCH http://localhost:3025/dipendenti/{idDipendente}
    @PatchMapping("/{idDipendente}/avatar")
    public String uploadImage(@PathVariable UUID idDipendente, @RequestParam("user_picture") MultipartFile file) {
        String url = this.dipendenteService.uploadAvatar(idDipendente, file);

        return url;

    }
}
