package dev.warrior.web.service;

import dev.warrior.web.dto.input.SkillInputDto;
import dev.warrior.web.model.Skill;
import dev.warrior.web.repository.SkillRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillCategoryService skillCategoryService;

    public Skill retrieveOrInsert(SkillInputDto skillInputDto) {
        String skillName = WordUtils.capitalizeFully(skillInputDto.getName());
        return Optional.ofNullable(getSkillByName(skillName))
            .orElseGet(() -> {
                Skill newSkill = new Skill(skillInputDto.getName());
                newSkill.setSkillCategory(skillCategoryService
                        .getSkillCategoryById(skillInputDto.getSkillCategoryId()));
                return skillRepository.save(newSkill);
            });
    }

    @Cacheable(value = "skills", key = "#name", unless = "#result == null")
    private Skill getSkillByName(String name) {
        return skillRepository.findOneByName(name).orElse(null);
    }

}
