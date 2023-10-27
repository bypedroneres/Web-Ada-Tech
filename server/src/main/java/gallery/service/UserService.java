package gallery.service;

import java.util.List;
import java.util.Optional;

import gallery.domain.dto.user.UserPostDTO;
import gallery.domain.dto.user.UserPutDTO;
import gallery.domain.dto.user.UserResponseDTO;
import gallery.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import gallery.domain.entities.User;
import gallery.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
  @Autowired
  private final UserRepository userRepository;
  @Autowired
  private final UserMapper mapper;

  public UserService(UserRepository userRepository, UserMapper mapper) {
    this.userRepository = userRepository;
    this.mapper = mapper;
  }

  public Page<UserResponseDTO> buscarTodosOsUsuarios(Pageable pageable) {
    return userRepository.findAll(pageable).map(mapper::toResponseDto);
  }

  public UserResponseDTO buscarUsuarioPorId(String id) {
    User user = userRepository.getReferenceById(id);

    return mapper.toResponseDto(user);
  }

  public UserResponseDTO criarNovoUsuario(UserPostDTO userPostDTO) {
    User user = mapper.postDtoToEntity(userPostDTO);
    userRepository.save(user);

    return mapper.toResponseDto(userRepository.getReferenceById(user.getId()));
  }

  public void deletarUsuario(String id) {
    userRepository.deleteById(id);
  }

  public UserResponseDTO atualizar(String id, UserPutDTO userPutDTO){
    User user = userRepository.getReferenceById(id);
    User userAtualizado = mapper.putDtoToEntity(userPutDTO);

    user.atualizar(userAtualizado);
    userRepository.save(user);

    return mapper.toResponseDto(userRepository.getReferenceById(user.getId()));
  }
}