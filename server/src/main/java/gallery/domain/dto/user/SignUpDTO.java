package gallery.domain.dto.user;

import gallery.domain.entities.UserRole;

public record SignUpDTO(String email, String username, String password, UserRole role) {
  
}
