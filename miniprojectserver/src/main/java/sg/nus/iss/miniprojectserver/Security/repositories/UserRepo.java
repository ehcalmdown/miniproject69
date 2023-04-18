package sg.nus.iss.miniprojectserver.Security.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import sg.nus.iss.miniprojectserver.Security.models.User;


public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
  
  }
