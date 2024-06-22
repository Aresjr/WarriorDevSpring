package dev.warrior.web.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Skill skill;

    private Long level;
}
