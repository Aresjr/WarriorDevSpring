package dev.warrior.web.service;

import dev.warrior.web.dto.input.SkillCategoryInputDto;
import dev.warrior.web.dto.input.SkillInputDto;
import dev.warrior.web.model.Skill;
import dev.warrior.web.repository.SkillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class SkillServiceTest {

    @Autowired
    private SkillService skillService;

    @Autowired
    private SkillRepository skillRepository;

    @Test
    void testRetrieveOrInsert() {
        SkillCategoryInputDto coding = new SkillCategoryInputDto("Coding");

        SkillInputDto skillInputDto = new SkillInputDto("Java", coding);
        Skill skill = skillService.retrieveOrInsert(skillInputDto);
        Assertions.assertNotNull(skill);

        Long skillId = skill.getId();
        Assertions.assertNotNull(skillId);
        Assertions.assertEquals("Java", skill.getName());
        Assertions.assertEquals(1, skillRepository.count());
        Assertions.assertTrue(skillRepository.findOneByName("Java").isPresent());


        SkillInputDto skillInputDto2 = new SkillInputDto("Java", coding);
        Skill skill2 = skillService.retrieveOrInsert(skillInputDto2);
        Assertions.assertEquals(skillId, skill2.getId());
        Assertions.assertEquals("Java", skill2.getName());
        Assertions.assertTrue(skillRepository.findOneByName("Java").isPresent());

        SkillInputDto skillInputDto3 = new SkillInputDto("java", coding);
        Skill skill3 = skillService.retrieveOrInsert(skillInputDto3);
        Assertions.assertEquals(skillId, skill3.getId());
        Assertions.assertEquals("Java", skill3.getName());
        Assertions.assertTrue(skillRepository.findOneByName("Java").isPresent());
    }

}
