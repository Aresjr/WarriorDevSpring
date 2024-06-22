package dev.warrior.web.dto.input;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SkillInputDto {

    private String name;

    private SkillCategoryInputDto skillCategory;
}
