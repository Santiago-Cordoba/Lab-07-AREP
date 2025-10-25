package escuelaing.arep.Lab07.Controller;

import escuelaing.arep.Lab07.DTO.CreateUserRequest;
import escuelaing.arep.Lab07.Model.User;
import escuelaing.arep.Lab07.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    public UserController(UserService userService) { this.userService = userService; }


    @PostMapping
    public ResponseEntity<User> create(@Validated @RequestBody CreateUserRequest req) {
        User u = User.builder().name(req.getName()).username(req.getUsername()).email(req.getEmail()).build();
        User saved = userService.create(u);
        return ResponseEntity.created(URI.create("/users/" + saved.getId())).body(saved);
    }


    @GetMapping
    public ResponseEntity<List<User>> list() { return ResponseEntity.ok(userService.list()); }


    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") java.util.UUID id) { return ResponseEntity.ok(userService.getById(id)); }
}
