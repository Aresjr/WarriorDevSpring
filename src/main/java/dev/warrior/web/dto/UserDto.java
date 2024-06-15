package dev.warrior.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.warrior.web.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class UserDto {

    private String name;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private List<SkillDto> skills;

    public User toDomain() {
        return User.builder().name(name).username(username).password(password).build();
    }

    public static UserDto fromDomain(User user) {
        return UserDto.builder()
                .name(user.getName())
                .username(user.getUsername())
                .skills(
                      user.getSkills().stream().map(skill -> new SkillDto(skill.getName())).toList()
                )
                .build();
    }

}
