package dev.warrior.web.repository;

import dev.warrior.web.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    Optional<Skill> findOneByName(String name);
}
