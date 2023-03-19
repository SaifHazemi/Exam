package tn.inetum.blm.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Entities.User;

public interface ProjetRepository extends JpaRepository<Projet,Integer> {
}
