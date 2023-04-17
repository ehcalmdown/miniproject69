package sg.nus.iss.miniprojectserver.Security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.miniprojectserver.Security.models.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}