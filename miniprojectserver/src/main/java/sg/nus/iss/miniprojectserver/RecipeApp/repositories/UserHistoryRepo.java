package sg.nus.iss.miniprojectserver.RecipeApp.repositories;

import sg.nus.iss.miniprojectserver.RecipeApp.models.UserHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserHistoryRepo extends JpaRepository<UserHistory, Long>{
    List<UserHistory> findByUserId(Long userId);
    
}