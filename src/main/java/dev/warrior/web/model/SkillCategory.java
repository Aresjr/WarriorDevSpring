package dev.warrior.web.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

}
