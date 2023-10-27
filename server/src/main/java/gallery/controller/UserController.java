package gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import gallery.domain.entities.User;
import gallery.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/listar")
  public List<User> getUsers() {
    return userService.buscarTodosOsUsuarios();
  }

  @GetMapping("/nome")
  public List<User> getUsersPorNome(@RequestParam String nome) {
    return userService.buscarPorNome(nome);
  }

  @DeleteMapping("/{id}/excluir")
  public void excluirUsuario(@PathVariable String id) {
    userService.deletarUsuario(id);
  }

  @PostMapping("/criar")
  public User criarUsuario(@RequestBody User usuario) {
    return userService.criarNovoUsuario(usuario);
  }

  @PutMapping("/{id}/atualizar-nome")
  public User atualizarNome(@PathVariable String id, @RequestBody User usuario) {
    return userService.atualizarNome(id, usuario.getUsername());
  }

  @PutMapping("/{id}/atualizar-email")
  public User atualizarEmail(@PathVariable String id, @RequestBody User usuario) {
    return userService.atualizarEmail(id, usuario.getEmail());
  }

  @PutMapping("/{id}/atualizar-password")
  public User atualizarPassword(@PathVariable String id, @RequestBody User usuario) {
    return userService.atualizarPassword(id, usuario.getPassword());
  }

}
