package gallery.domain.dto.user;

import gallery.domain.entities.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserPostDTO(
        @NotNull String id,
        @NotBlank String username,
        @NotBlank String email,
        @NotNull String password,
        @NotNull UserRole role
) {
}
