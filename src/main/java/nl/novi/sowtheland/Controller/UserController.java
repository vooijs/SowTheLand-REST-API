package nl.novi.sowtheland.Controller;

import nl.novi.sowtheland.Dto.UserDto;
import nl.novi.sowtheland.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<Object> createUser (@RequestBody UserDto userDto){
        Long newUserId = userService.createUser(userDto).getBody();
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + newUserId).toUriString());

        return ResponseEntity.created(uri).body(userDto);
    }
    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/search")

    public ResponseEntity <UserDto> getUser (@RequestParam String email){
        return ResponseEntity.ok(userService.getUser(email));
    }
}
