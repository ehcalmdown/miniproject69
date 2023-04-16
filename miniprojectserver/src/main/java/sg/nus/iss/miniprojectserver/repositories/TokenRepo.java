package sg.nus.iss.miniprojectserver.repositories;

import org.springframework.data.jpa.repository.Query;

import sg.nus.iss.miniprojectserver.models.Token;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<Token, Integer> {

    @Query(value = """
        select t from Token t inner join User u\s
        on t.user.id = u.id\s
        where u.id = :id and (t.expired = false or t.revoked = false)\s
        """)
    List<Token> findAllValidTokenByUser(Integer id);
  
    Optional<Token> findByToken(String token);
  }