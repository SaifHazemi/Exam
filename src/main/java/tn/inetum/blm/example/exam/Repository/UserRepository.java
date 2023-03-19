package tn.inetum.blm.example.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inetum.blm.example.exam.Entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
