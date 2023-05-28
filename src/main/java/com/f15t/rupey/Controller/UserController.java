package com.f15t.rupey.Controller;

import com.f15t.rupey.Response.UserResponse;
import com.f15t.rupey.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/apiV1/user")
public class UserController {

    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserResponse response) {
        return userService.createUser(response);
    }

    @GetMapping("/{username}")
    public UserResponse findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody UserResponse response) {
        return userService.updateUser(response);
    }

    @DeleteMapping
    public Optional<UserResponse> deleteUser(@RequestBody UserResponse response) {
        return userService.deleteUser(response);
    }

}
