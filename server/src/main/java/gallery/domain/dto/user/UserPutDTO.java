package gallery.domain.dto.user;

import gallery.domain.entities.UserRole;

public record UserPutDTO(
        String username,
        String email,
        String password,
        UserRole role
) {
}
