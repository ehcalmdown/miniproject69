package sg.nus.iss.miniprojectserver.RecipeApi.repositories;

import sg.nus.iss.miniprojectserver.RecipeApi.models.UserHistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long>{
    List<UserHistory> findByUserId(Long userId);
    
}
