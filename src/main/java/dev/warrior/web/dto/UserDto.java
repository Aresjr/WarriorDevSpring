package dev.warrior.web.dto;

import dev.warrior.web.model.User;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class UserDto {

    private String name;

    private String username;

    private String password;

    private List<SkillDto> skills;

    public User toDomain() {
        return User.builder().name(name).username(username).password(password).build();
    }

}
