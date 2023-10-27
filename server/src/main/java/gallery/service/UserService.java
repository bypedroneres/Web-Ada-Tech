package gallery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import gallery.domain.entities.User;
import gallery.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
      this.userRepository = userRepository;
    }

    public List<User> buscarTodosOsUsuarios() {
      return userRepository.findAll();
    }

    public User buscarUsuarioPorId(String id) {
      Optional<User> optionalUser = userRepository.findById(id);
      return optionalUser.orElse(null);
    }

    public User criarNovoUsuario(User usuario) {
      return userRepository.save(usuario);
    }

    public void deletarUsuario(String id) {
      userRepository.deleteById(id);
    }

    public User atualizarNome(String id, String novoNome) {
      Optional<User> optionalUser = userRepository.findById(id);

      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        user.setUsername(novoNome);
        return userRepository.save(user);
      } else {
        return null;
      }
    }

    public User atualizarEmail(String id, String novoEmail) {
      Optional<User> optionalUser = userRepository.findById(id);

      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        user.setEmail(novoEmail);
        return userRepository.save(user);
      } else {
        return null;
      }
    }

    public User atualizarPassword(String id, String novaPassword) {
      Optional<User> optionalUser = userRepository.findById(id);

      if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        user.setPassword(novaPassword);
        return userRepository.save(user);
      } else {
        return null;
      }
    }

  public User buscarPorId(Long id) {
    Optional<User> optCliente = userRepository.findById(id);
    User cliente = optCliente.orElseThrow(() -> new RuntimeException("Não existe cliente com esse id"));
    return new User(cliente);
  }

  public List<User> buscarPorNome(String nome) {
    List<User> clientes = userRepository.findByNomeCompletoCustom(nome);
    return clientes;
  }

  public void deletarCliente(Long id) {
    userRepository.deleteById(id);
  }
}