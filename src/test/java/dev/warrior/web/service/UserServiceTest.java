package dev.warrior.web.service;

import dev.warrior.web.dto.input.UserInputDto;
import dev.warrior.web.model.User;
import dev.warrior.web.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void testInsertUserDto() {
        UserInputDto userInputDto = UserInputDto.builder().name("Ares").username("ares").password("password").build();

        User user = userService.save(userInputDto);
        Assertions.assertNotNull(user);
        Long userId = user.getId();
        Assertions.assertNotNull(userId);

        User userSaved = userRepository.findOneByUsername("ares")
                .orElseThrow(() -> new RuntimeException("User not found"));
        Assertions.assertEquals("Ares", userSaved.getName());
        Assertions.assertEquals("ares", userSaved.getUsername());
        Assertions.assertEquals("password", userSaved.getPassword());
        Assertions.assertEquals(userId, userSaved.getId());
    }

}
