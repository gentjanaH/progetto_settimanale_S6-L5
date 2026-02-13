package gentjanahani.progettou2w6d5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DipendenteDTO(
        @NotBlank(message = "Lo username è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Lo username deve essere tra i 2 e i 30 caratteri")
        String username,
        @NotBlank(message = "Il nome è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Il nome proprio deve essere tra i 2 e i 30 caratteri")
        String name,
        @NotBlank(message = "Il cognome è un campo obbligatorio")
        @Size(min = 2, max = 30, message = "Il cognome deve essere tra i 2 e i 30 caratteri")
        String surname,
        @NotBlank(message = "La mail è un campo obbligatorio")
        @Email(message = "L'indirizzo mail fornito non è nel formato corretto")
        String mail
) {
}
