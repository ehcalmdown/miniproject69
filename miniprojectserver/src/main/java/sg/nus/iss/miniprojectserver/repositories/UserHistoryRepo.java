package sg.nus.iss.miniprojectserver.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.miniprojectserver.models.UserHistory;


@Repository
public interface UserHistoryRepo extends JpaRepository<UserHistory, Long>{
    List<UserHistory> findByUserId(Long userId);
    
}
