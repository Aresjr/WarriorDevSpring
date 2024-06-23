package dev.warrior.web.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    public SkillCategory(String name) {
        this.name = name;
    }

}
