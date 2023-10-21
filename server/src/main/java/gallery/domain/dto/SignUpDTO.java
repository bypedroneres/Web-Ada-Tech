package gallery.domain.dto;

import gallery.domain.entities.UserRole;

public record SignUpDTO(String email, String username, String password, UserRole role) {
  
}
