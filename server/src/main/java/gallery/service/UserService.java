package gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gallery.domain.entities.User;
import gallery.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getUsers() {
    return this.userRepository.findAll();
  }
}
