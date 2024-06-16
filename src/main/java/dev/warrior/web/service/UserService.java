package dev.warrior.web.service;

import dev.warrior.web.dto.UserDto;
import dev.warrior.web.error.UserNotFoundException;
import dev.warrior.web.model.Skill;
import dev.warrior.web.model.User;
import dev.warrior.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillService skillService;

    public User save(UserDto userDto) {
        User user = userDto.toDomain();

        List<Skill> skills = userDto.getSkills().stream()
                .map(skillDto -> skillService.upsert(skillDto)).toList();

        user.setSkills(skills);
        return userRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::fromDomain).toList();
    }

    public UserDto getByUsername(String username) {
        return UserDto.fromDomain(userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    public UserDto getById(Long id) {
        return UserDto.fromDomain(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found")));
    }
}
