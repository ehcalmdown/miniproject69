package sg.nus.iss.miniprojectserver.RecipeApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sg.nus.iss.miniprojectserver.RecipeApp.models.Recipe;
import sg.nus.iss.miniprojectserver.RecipeApp.models.UserHistory;
import sg.nus.iss.miniprojectserver.RecipeApp.services.UserService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/recipes")
    public List<Recipe> getRecipes(@RequestParam String cuisine) {
        return userService.findRecipesByCuisine(cuisine);
    }

    @GetMapping("/wine")
    public String getWinePairing(@RequestParam String cuisine) {
        return userService.findWinePairingByCuisine(cuisine);
    }

    @GetMapping("/history/{userId}")
    public List<UserHistory> getUserHistory(@PathVariable Long userId) {
        return userService.getUserHistory(userId);
    }

    @PostMapping("/history")
    public UserHistory saveUserHistory(@RequestBody UserHistory userHistory) {
        return userService.saveUserHistory(userHistory);
    }

    @PutMapping("/history/{id}")
    public ResponseEntity<UserHistory> updateUserHistory(@PathVariable Long id, @RequestBody UserHistory userHistory) {
        UserHistory updatedUserHistory = userService.updateUserHistory(id, userHistory);
        return ResponseEntity.ok(updatedUserHistory);
}
}
