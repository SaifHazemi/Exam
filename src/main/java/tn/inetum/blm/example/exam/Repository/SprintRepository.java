package tn.inetum.blm.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Entities.Sprint;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {
}
