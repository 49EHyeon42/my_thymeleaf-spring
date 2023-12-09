package dev.ehyeon.my_thymeleaf;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApiRepository {

    private final UserService userService;

    public UserApiRepository(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public void registerUser(@RequestBody RegisterUserRequest request) {
        userService.saveUser(request.getName());
    }
}
