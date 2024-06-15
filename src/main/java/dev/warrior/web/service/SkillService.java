package dev.warrior.web.service;

import dev.warrior.web.dto.SkillDto;
import dev.warrior.web.model.Skill;
import dev.warrior.web.repository.SkillRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public Skill upsert(SkillDto skillDto) {
        skillDto.setName(WordUtils.capitalizeFully(skillDto.getName()));
        return skillRepository.findOneByName(skillDto.getName())
                .orElseGet(() -> skillRepository.save(skillDto.toModel()));
    }

}
