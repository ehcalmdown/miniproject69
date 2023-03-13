package sg.nus.iss.miniprojectserver.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import sg.nus.iss.miniprojectserver.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
