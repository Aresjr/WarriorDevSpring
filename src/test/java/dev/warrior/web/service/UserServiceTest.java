package dev.warrior.web.service;

import dev.warrior.web.dto.SkillDto;
import dev.warrior.web.dto.UserDto;
import dev.warrior.web.model.User;
import dev.warrior.web.repository.SkillRepository;
import dev.warrior.web.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        skillRepository.deleteAll();
    }

    @Test
    void testInsertUserDto() {
        SkillDto java = new SkillDto("java");
        SkillDto springBoot = new SkillDto("spring boot");
        UserDto userDto = UserDto.builder().name("Ares").username("ares")
                .password("password").skills(List.of(java, springBoot)).build();
        User user = userService.save(userDto);
        Assertions.assertNotNull(user);
        Long userId = user.getId();
        Assertions.assertNotNull(userId);
        Assertions.assertEquals("Ares", user.getName());
        Assertions.assertEquals("ares", user.getUsername());
        Assertions.assertEquals("password", user.getPassword());
        Assertions.assertEquals(2, user.getSkills().size());

        Assertions.assertEquals(2, skillRepository.count());
        Assertions.assertTrue(skillRepository.findOneByName("Java").isPresent());
        Assertions.assertTrue(skillRepository.findOneByName("Spring Boot").isPresent());

        User userSaved = userRepository.findOneByUsername("ares")
                .orElseThrow(() -> new RuntimeException("User not found"));
        Assertions.assertEquals(2, userSaved.getSkills().size());
    }

}
