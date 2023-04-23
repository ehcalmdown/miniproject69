package sg.nus.iss.miniprojectserver.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.nus.iss.miniprojectserver.models.Recipe;
import sg.nus.iss.miniprojectserver.models.UserHistory;


@Service
public interface RecipeServiceData {

    List<Recipe> findRecipesByCuisine(String cuisine);

    String findWinePairingByCuisine(String cuisine);

    List<UserHistory> getUserHistory(Long userId);

    UserHistory saveUserHistory(UserHistory userHistory);

    UserHistory updateUserHistory(Long id, UserHistory updatedUserHistory);
    
}
