package dev.warrior.web.service;

import dev.warrior.web.model.SkillCategory;
import dev.warrior.web.repository.SkillCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SkillCategoryService {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    //TODO - capitalize before calling WordUtils.capitalizeFully
    @Cacheable("skillCategories")
    public SkillCategory retrieveOrInsert(String skillCategoryName) {
        return skillCategoryRepository.findOneByName(skillCategoryName)
                .orElseGet(() -> skillCategoryRepository.save(new SkillCategory(skillCategoryName)));
    }

}
