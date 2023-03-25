package tn.inetum.blm.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.inetum.blm.example.exam.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.fname = ?1 and u.iname = ?2")
    User findByFnameAndIname(String firstName, String lastName);


}
