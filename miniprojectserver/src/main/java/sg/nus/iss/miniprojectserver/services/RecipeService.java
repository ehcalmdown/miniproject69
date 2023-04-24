package sg.nus.iss.miniprojectserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.nus.iss.miniprojectserver.exceptions.ResourceNotFoundException;
import sg.nus.iss.miniprojectserver.models.Recipe;
import sg.nus.iss.miniprojectserver.models.RecipeResponse;
import sg.nus.iss.miniprojectserver.models.UserHistory;
// import sg.nus.iss.miniprojectserver.models.UserInfo;
import sg.nus.iss.miniprojectserver.models.WinePairingResponse;
import sg.nus.iss.miniprojectserver.repositories.UserHistoryRepo;
// import sg.nus.iss.miniprojectserver.repositories.UserInfoRepository;


@Service
public class RecipeService implements RecipeServiceData{

    

    @Autowired
    private UserHistoryRepo userHistoryRepo;

    private final String apiKey = "70c6b7aaaamshff74d5a45a9bf81p14ae31jsn0263850fec91";//apiKey please remember to remove
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
        return userHistoryRepo.findByUserInfoId(userId);
    }

    @Override
    public UserHistory saveUserHistory(UserHistory userHistory) {
        return userHistoryRepo.save(userHistory);
    }

    @Override
public UserHistory updateUserHistory(Long id, UserHistory updatedUserHistory) {
    return userHistoryRepo.findById(id)
            .map(existingUserHistory -> {
                // Update the properties of the existingUserHistory object with the properties from updatedUserHistory
                existingUserHistory.setCuisine(updatedUserHistory.getCuisine());
                existingUserHistory.setRecipes(updatedUserHistory.getRecipes());
                existingUserHistory.setWine(updatedUserHistory.getWine());
                existingUserHistory.setSearchTime(updatedUserHistory.getSearchTime());
                return userHistoryRepo.save(existingUserHistory);
            })
            .orElseThrow(() -> new ResourceNotFoundException("UserHistory not found with ID: " + id));
}
    
}
