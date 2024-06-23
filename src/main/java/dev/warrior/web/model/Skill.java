package dev.warrior.web.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToOne(optional = false)
    private SkillCategory skillCategory;

    public Skill(String name) {
        this.name = name;
    }
}
