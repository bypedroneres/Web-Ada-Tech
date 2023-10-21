package gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import gallery.domain.entities.User;
import gallery.service.UserService;

public class UserController {
  @Autowired
  private UserService userService;
  
  @GetMapping("/users")
  public List<User> getUsers() {
    return this.userService.getUsers();
  }
}
