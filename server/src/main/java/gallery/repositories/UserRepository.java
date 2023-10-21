package gallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import gallery.domain.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

  UserDetails findByEmail(String email);
}
