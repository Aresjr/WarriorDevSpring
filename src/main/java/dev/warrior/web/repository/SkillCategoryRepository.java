package dev.warrior.web.repository;

import dev.warrior.web.model.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {

    Optional<SkillCategory> findOneByName(String name);
}
