package dev.warrior.web.dto;

import dev.warrior.web.model.Skill;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SkillDto {

    private String name;

    public Skill toModel() {
        return new Skill(name);
    }

    public SkillDto(String name) {
        this.name = name;
    }

}
