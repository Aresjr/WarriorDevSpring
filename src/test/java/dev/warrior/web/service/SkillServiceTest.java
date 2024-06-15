package dev.warrior.web.service;

import dev.warrior.web.dto.SkillDto;
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
    void testUpsert() {
        SkillDto skillDto = new SkillDto("Java");
        Skill skill = skillService.upsert(skillDto);
        Assertions.assertNotNull(skill);

        Long skillId = skill.getId();
        Assertions.assertNotNull(skillId);
        Assertions.assertEquals("Java", skill.getName());

        SkillDto skillDto2 = new SkillDto("Java");
        Skill skill2 = skillService.upsert(skillDto2);
        Assertions.assertEquals(skillId, skill2.getId());
        Assertions.assertEquals("Java", skill2.getName());

        SkillDto skillDto3 = new SkillDto("java");
        Skill skill3 = skillService.upsert(skillDto2);
        Assertions.assertEquals(skillId, skill3.getId());
        Assertions.assertEquals("Java", skill3.getName());
    }

}
