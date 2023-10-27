package gallery.domain.dto.user;

import gallery.domain.entities.UserRole;

public record UserResponseDTO(String id, String username, String email, String password, UserRole role) {}
