package gentjanahani.progettou2w6d5.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ViaggioStatusDTO(
        @NotBlank(message = "Lo stato è obbligatorio")
        @Size(min = 2, max = 15, message = "Lo stato deve contenere un mindi 2 caratteri e un max di 15")
        String stato) {
}
