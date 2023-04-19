package sg.nus.iss.miniprojectserver.RecipeApi.services;

import java.util.List;

import sg.nus.iss.miniprojectserver.RecipeApi.models.Recipe;
import sg.nus.iss.miniprojectserver.RecipeApi.models.UserHistory;

public interface UserService {

    List<Recipe> findRecipesByCuisine(String cuisine);

    String findWinePairingByCuisine(String cuisine);

    List<UserHistory> getUserHistory(Long userId);

    UserHistory saveUserHistory(UserHistory userHistory);

    UserHistory updateUserHistory(Long id, UserHistory updatedUserHistory);
}
