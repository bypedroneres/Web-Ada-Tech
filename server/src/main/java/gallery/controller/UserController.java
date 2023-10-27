package gallery.controller;

import gallery.domain.dto.user.UserPostDTO;
import gallery.domain.dto.user.UserPutDTO;
import gallery.domain.dto.user.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gallery.service.UserService;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public Page<UserResponseDTO> getUsers(Pageable pageable) {
    return userService.buscarTodosOsUsuarios(pageable);
  }

  @GetMapping("/{id}")
  public UserResponseDTO getUsers(@PathVariable String id) {
    return userService.buscarUsuarioPorId(id);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void excluirUsuario(@PathVariable String id) {
    userService.deletarUsuario(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResponseDTO> criarUsuario(@RequestBody UserPostDTO userPostDTO, UriComponentsBuilder uriBuilder){
    UserResponseDTO user = userService.criarNovoUsuario(userPostDTO);

    URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.id()).toUri();

    return ResponseEntity.created(uri).body(user);
  }

  @PutMapping("/{id}")
  public UserResponseDTO atualizar(@PathVariable String id, @RequestBody UserPutDTO userPutDTO) {
    return userService.atualizar(id, userPutDTO);
  }
}
