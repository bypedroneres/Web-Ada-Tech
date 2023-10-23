package gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import gallery.domain.entities.User;
import gallery.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("users")
public class UserController {
  @Autowired
  private UserService userService;
  
  @GetMapping
  public List<User> getUsers() {
    return this.userService.getUsers();
  }
}
