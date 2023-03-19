package tn.inetum.blm.example.exam.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String email;
    private String pwd;
    private String fname;
    private String Iname;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany
    private List<Projet> projetList;
    @OneToMany
    private List<Projet> projet;

}
