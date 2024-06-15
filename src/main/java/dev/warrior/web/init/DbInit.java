package dev.warrior.web.init;

import dev.warrior.web.dto.SkillDto;
import dev.warrior.web.dto.UserDto;
import dev.warrior.web.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbInit {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initSkills()  {
        //TODO - import skills and users
        System.out.println("TODO - import skills and users");

        SkillDto java = new SkillDto("Java");
        SkillDto springBoot = new SkillDto("Spring Boot");
        UserDto ares = UserDto.builder().name("Ares").username("ares").password("1234")
                .skills(List.of(springBoot)).build();
    }

}
