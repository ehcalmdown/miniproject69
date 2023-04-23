package sg.nus.iss.miniprojectserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import sg.nus.iss.miniprojectserver.models.AuthRequest;
import sg.nus.iss.miniprojectserver.models.Recipe;
import sg.nus.iss.miniprojectserver.models.UserHistory;
import sg.nus.iss.miniprojectserver.models.UserInfo;
import sg.nus.iss.miniprojectserver.services.JwtService;
import sg.nus.iss.miniprojectserver.services.RecipeService;
import sg.nus.iss.miniprojectserver.services.RecipeServiceData;

import java.util.List;

@RestController
@RequestMapping("/recipeapp")
public class AppController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/test")
    public String test() {
        return "not secure yet";
    }

    @PostMapping("/newuser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return recipeService.addUser(userInfo);
    }

    @Autowired
    private RecipeServiceData recipeServiceData;

    @PostMapping("/recipes")
    public List<Recipe> getRecipes(@RequestParam String cuisine) {
        return recipeServiceData.findRecipesByCuisine(cuisine);
    }

    @GetMapping("/wine")
    public String getWinePairing(@RequestParam String cuisine) {
        return recipeServiceData.findWinePairingByCuisine(cuisine);
    }

    @GetMapping("/history/{userId}")
    public List<UserHistory> getUserHistory(@PathVariable Long userId) {
        return recipeServiceData.getUserHistory(userId);
    }

    @PostMapping("/history")
    public UserHistory saveUserHistory(@RequestBody UserHistory userHistory) {
        return recipeServiceData.saveUserHistory(userHistory);
    }

    @PutMapping("/history/{id}")
    public ResponseEntity<UserHistory> updateUserHistory(@PathVariable Long id, @RequestBody UserHistory userHistory) {
        UserHistory updatedUserHistory = recipeServiceData.updateUserHistory(id, userHistory);
        return ResponseEntity.ok(updatedUserHistory);
}

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
}
