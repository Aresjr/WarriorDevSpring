package dev.warrior.web.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSkillInputDto {

    private UserInputDto user;

    private SkillInputDto skill;

}
