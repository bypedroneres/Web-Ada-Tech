package gallery.domain.dto.user;

import jakarta.validation.constraints.NotBlank;

public record SignInDTO(@NotBlank String email, @NotBlank String password) {
}
