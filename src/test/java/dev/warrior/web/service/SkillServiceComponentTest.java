package dev.warrior.web.service;

import dev.warrior.web.dto.input.SkillInputDto;
import dev.warrior.web.model.Skill;
import dev.warrior.web.model.SkillCategory;
import dev.warrior.web.repository.SkillCategoryRepository;
import dev.warrior.web.repository.SkillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class SkillServiceComponentTest {

    @Autowired
    private SkillService skillService;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @BeforeEach
    void setUp() {
        skillRepository.deleteAll();
        skillCategoryRepository.deleteAll();
        SkillCategory coding = new SkillCategory("Coding");
        skillCategoryRepository.save(coding);
        SkillCategory framework = new SkillCategory("Framework");
        skillCategoryRepository.save(framework);
    }

    @Test
    void testRetrieveOrInsert() {
        SkillCategory framework = skillCategoryRepository.findOneByName("Framework")
                .orElseThrow(() -> new IllegalArgumentException("Skill category not found"));
        SkillInputDto skillInputDto = new SkillInputDto("Spring Boot", framework.getId());
        Skill skill = skillService.retrieveOrInsert(skillInputDto);
        Assertions.assertNotNull(skill);

        Long skillId = skill.getId();
        Assertions.assertNotNull(skillId);
        Assertions.assertEquals("Spring Boot", skill.getName());
        Assertions.assertEquals(1, skillRepository.count());
        Assertions.assertTrue(skillRepository.findOneByName("Spring Boot").isPresent());

        SkillInputDto skillInputDto2 = new SkillInputDto("Spring Boot", framework.getId());
        Skill skill2 = skillService.retrieveOrInsert(skillInputDto2);
        Assertions.assertEquals(skillId, skill2.getId());
        Assertions.assertEquals("Spring Boot", skill2.getName());
        Assertions.assertTrue(skillRepository.findOneByName("Spring Boot").isPresent());

        SkillInputDto skillInputDto3 = new SkillInputDto("spring boot", framework.getId());
        Skill skill3 = skillService.retrieveOrInsert(skillInputDto3);
        Assertions.assertEquals(skillId, skill3.getId());
        Assertions.assertEquals("Spring Boot", skill3.getName());
        Assertions.assertTrue(skillRepository.findOneByName("Spring Boot").isPresent());
    }

}
