package dev.warrior.web.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "user_skill",
      joinColumns = @JoinColumn(name = "skill_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> users;

    public Skill(String name) {
        this.name = name;
    }

}
