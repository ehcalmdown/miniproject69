package sg.nus.iss.miniprojectserver.repositories;

import org.springframework.data.jpa.repository.Query;

import sg.nus.iss.miniprojectserver.models.Token;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<Token, Long>{

    
    Optional<Token> findByToken(String token);
}
