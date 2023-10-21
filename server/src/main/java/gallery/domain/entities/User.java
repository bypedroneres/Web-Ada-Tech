package gallery.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String username;
  private String email;
  private String password;
  private UserRole role;

  public User(String username, String email, String password, UserRole role){
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (this.role == UserRole.ADMIN)
      return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
    else
      return List.of(new SimpleGrantedAuthority("ROLE_USER"));
  }
}
