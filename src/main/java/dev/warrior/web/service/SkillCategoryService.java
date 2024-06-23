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

    @Cacheable("skillCategories")
    public SkillCategory getSkillCategoryById(Long id) {
        return skillCategoryRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Skill category not found"));
    }

}
