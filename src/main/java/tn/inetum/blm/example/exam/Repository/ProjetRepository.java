package tn.inetum.blm.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.inetum.blm.example.exam.Entities.Projet;
import tn.inetum.blm.example.exam.Entities.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet,Integer> {
    @Query("select p from Projet p inner join p.sprintList sprintList where sprintList.startDate > CURRENT_DATE")
    List<Projet> findByAndSprintListStartDateAfter();
    @Query("select p from Projet p inner join p.sprintList sprintList where sprintList.startDate > CURRENT_DATE order by p.id")
    List<Projet> findByAndSprintListStartDateAfterOrderById();
}
