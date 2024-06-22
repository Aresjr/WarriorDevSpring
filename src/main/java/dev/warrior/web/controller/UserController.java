package dev.warrior.web.controller;

import dev.warrior.web.dto.input.UserInputDto;
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

    @GetMapping("/api/users")
    public ResponseEntity<List<UserInputDto>> getUsers() {
        return ResponseEntity.ok(null);
        //return ResponseEntity.ok(userService.getAllUsers());
    }

	@PostMapping("/api/user")
	public ResponseEntity<UserInputDto> addUser(@RequestBody UserInputDto userInputDto) {
		return ResponseEntity.status(HttpStatus.OK)
                .body(null);
	}

    @PutMapping("/api/user/{id}")
    public ResponseEntity<UserInputDto> updateUser(@RequestBody UserInputDto userInputDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(null);
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<UserInputDto> getUserById(@PathVariable Long id) {
        try {
            //return ResponseEntity.ok(userService.getById(id));
            return ResponseEntity.ok(null);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
