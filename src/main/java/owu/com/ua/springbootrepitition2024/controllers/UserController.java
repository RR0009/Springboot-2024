package owu.com.ua.springbootrepitition2024.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import owu.com.ua.springbootrepitition2024.dao.UserDao;
import owu.com.ua.springbootrepitition2024.models.User;
import owu.com.ua.springbootrepitition2024.models.userdto.UserDto;
import owu.com.ua.springbootrepitition2024.models.views.Views;
import owu.com.ua.springbootrepitition2024.services.UserService;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void saveUser(@RequestBody @Valid UserDto userDto) {

        userService.saveUser(userDto);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {

        return userService.getUserById(id);
    }

    @DeleteMapping()
    public List<User> deleteUser(@RequestParam int id) {
        return userService.deleteById(id);

    }

//    @GetMapping("/level1")
//    @JsonView(Views.Level1.class)
//    public List<User> getUserLevel1() {
//       return userDao.findAll();
//
//    }

}
