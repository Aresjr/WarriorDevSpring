package dev.warrior.web.service;

import dev.warrior.web.dto.input.UserInputDto;
import dev.warrior.web.error.UserNotFoundException;
import dev.warrior.web.model.User;
import dev.warrior.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(UserInputDto userInputDto) {
        User user = userInputDto.toDomain();
        return userRepository.save(user);
    }

    /*
    public List<UserInputDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserInputDto::fromDomain).toList();
    }

    public UserInputDto getByUsername(String username) {
        return UserInputDto.fromDomain(userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    public UserInputDto getById(Long id) {
        return UserInputDto.fromDomain(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }
     */
}
