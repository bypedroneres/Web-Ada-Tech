package gallery.domain.dto.user;

import gallery.domain.entities.Ticket;
import gallery.domain.entities.User;
import gallery.domain.entities.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserResponseDTO(@NotBlank String id, @NotBlank String username, @NotBlank String email, @NotBlank String password, @NotNull UserRole role) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
    }
}
