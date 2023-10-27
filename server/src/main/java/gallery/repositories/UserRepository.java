package gallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import gallery.domain.entities.User;


public interface UserRepository extends JpaRepository<User, String>{
    UserDetails findByEmail(String email);

  // @Query("SELECT c FROM User c WHERE c.username ILIKE concat('%', :nome, '%') ORDER BY c.username")
  // List<User> findByNomeCompletoCustom(@Param("nome") String nome);

  // Optional<User> findById(Long id);

  // void deleteById(Long id);
}
