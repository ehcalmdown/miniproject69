package sg.nus.iss.miniprojectserver.Security.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.miniprojectserver.Security.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
