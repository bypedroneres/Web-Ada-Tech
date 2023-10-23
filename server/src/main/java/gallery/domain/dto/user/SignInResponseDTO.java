package gallery.domain.dto.user;

import jakarta.validation.constraints.NotBlank;

public record SignInResponseDTO(@NotBlank String token) {
}
