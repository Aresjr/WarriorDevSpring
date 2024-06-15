package dev.warrior.web.controller;

import dev.warrior.web.dto.UserDto;
import dev.warrior.web.error.UserNotFoundException;
import dev.warrior.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/@{username}")
    public ResponseEntity<UserDto> getUserByUsername(String username) {
        try {
            return ResponseEntity.ok(userService.getByUsername(username.toLowerCase()));
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/api/user")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.OK)
                .body(UserDto.fromDomain(userService.save(userDto)));
	}

}
