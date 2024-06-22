package dev.warrior.web.init;

import dev.warrior.web.dto.input.SkillCategoryInputDto;
import dev.warrior.web.dto.input.SkillInputDto;
import dev.warrior.web.dto.input.UserInputDto;
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
        SkillCategoryInputDto coding = new SkillCategoryInputDto("Coding");
        SkillCategoryInputDto framework = new SkillCategoryInputDto("Framework");

        System.out.println("TODO - import skills and users");

        SkillInputDto java = new SkillInputDto("Java", coding);
        SkillInputDto springBoot = new SkillInputDto("Spring Boot", framework);
        UserInputDto ares = UserInputDto.builder().name("Ares").username("ares").password("1234")
                .skills(List.of(springBoot)).build();
    }

}
