package dev.warrior.web.model;

import dev.warrior.web.dto.input.UserInputDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserSkill> skills;

    public static User of(UserInputDto userInputDto) {
        return User.builder()
                .name(userInputDto.getName())
                .username(userInputDto.getUsername())
                .email(userInputDto.getEmail())
                .build();
    }
}
