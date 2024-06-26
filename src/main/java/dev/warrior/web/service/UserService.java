package dev.warrior.web.service;

import dev.warrior.web.dto.input.UserInputDto;
import dev.warrior.web.model.User;
import dev.warrior.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(UserInputDto userInputDto) {
        User user = User.of(userInputDto);
        user.setPassword(passwordEncoder.encode(userInputDto.getPassword()));
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
