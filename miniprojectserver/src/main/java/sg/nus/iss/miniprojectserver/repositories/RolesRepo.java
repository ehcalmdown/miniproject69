package sg.nus.iss.miniprojectserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sg.nus.iss.miniprojectserver.models.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}