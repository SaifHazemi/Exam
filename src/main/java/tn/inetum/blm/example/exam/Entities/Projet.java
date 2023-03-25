package tn.inetum.blm.example.exam.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Projet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "projet",cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Sprint> sprintList;
    @ManyToMany(mappedBy = "projetList")
    @JsonIgnore
    private List<User> userList;
}
