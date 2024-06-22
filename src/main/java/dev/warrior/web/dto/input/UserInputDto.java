package dev.warrior.web.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.warrior.web.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@ToString
public class UserInputDto {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private String password;

    private List<SkillInputDto> skills;

    private List<SkillCategoryInputDto> skillCategories;

    public User toDomain() {
        return User.builder().name(name).email(email).username(username).password(password).build();
    }

}
