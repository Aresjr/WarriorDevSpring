package dev.warrior.web.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SkillInputDto {

    @NotBlank
    private String name;

    private Long skillCategoryId;
}
