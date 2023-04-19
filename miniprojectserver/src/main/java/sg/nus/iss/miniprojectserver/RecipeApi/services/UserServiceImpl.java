package sg.nus.iss.miniprojectserver.RecipeApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.nus.iss.miniprojectserver.RecipeApi.models.Recipe;
import sg.nus.iss.miniprojectserver.RecipeApi.models.RecipeResponse;
import sg.nus.iss.miniprojectserver.RecipeApi.models.ResourceNotFoundException;
import sg.nus.iss.miniprojectserver.RecipeApi.models.UserHistory;
import sg.nus.iss.miniprojectserver.RecipeApi.models.WinePairingResponse;
import sg.nus.iss.miniprojectserver.RecipeApi.repositories.UserHistoryRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    private final String apiKey = "api-key";
    private final String apiUrl = "https://api.spoonacular.com";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Recipe> findRecipesByCuisine(String cuisine) {
        String url = apiUrl + "/recipes/complexSearch?cuisine=" + cuisine + "&apiKey=" + apiKey + "&number=5";
        RecipeResponse response = restTemplate.getForObject(url, RecipeResponse.class);
        return response != null ? response.getResults() : null;
    }

    @Override
    public String findWinePairingByCuisine(String cuisine) {
        String url = apiUrl + "/food/wine/pairing?food=" + cuisine + "&apiKey=" + apiKey;
        WinePairingResponse response = restTemplate.getForObject(url, WinePairingResponse.class);
        return response != null ? response.getWinePairingText() : null;
    }

    @Override
    public List<UserHistory> getUserHistory(Long userId) {
        return userHistoryRepository.findByUserId(userId);
    }

    @Override
    public UserHistory saveUserHistory(UserHistory userHistory) {
        return userHistoryRepository.save(userHistory);
    }

    @Override
public UserHistory updateUserHistory(Long id, UserHistory updatedUserHistory) {
    return userHistoryRepository.findById(id)
            .map(existingUserHistory -> {
                // Update the properties of the existingUserHistory object with the properties from updatedUserHistory
                existingUserHistory.setCuisine(updatedUserHistory.getCuisine());
                existingUserHistory.setRecipes(updatedUserHistory.getRecipes());
                existingUserHistory.setWine(updatedUserHistory.getWine());
                existingUserHistory.setSearchTime(updatedUserHistory.getSearchTime());
                return userHistoryRepository.save(existingUserHistory);
            })
            .orElseThrow(() -> new ResourceNotFoundException("UserHistory not found with ID: " + id));
}
}
