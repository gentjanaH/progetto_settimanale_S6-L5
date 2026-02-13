package gentjanahani.progettou2w6d5.payloads;

import jakarta.validation.constraints.NotNull;

public record ViaggioStatusDTO(
        @NotNull
        boolean completed) {
}
