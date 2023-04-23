package sg.nus.iss.miniprojectserver.models;

import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
// @Data
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
public class UserHistory {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String cuisine;

    @OneToMany(mappedBy = "userHistory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Recipe> recipes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id")
    private Wine wine;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime searchTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_info_id")
    private UserInfo userInfo;

    public UserHistory() {
    }

    public UserHistory(Long id, String cuisine, List<Recipe> recipes, Wine wine, LocalDateTime searchTime) {
        this.id = id;
        this.cuisine = cuisine;
        this.recipes = recipes;
        this.wine = wine;
        this.searchTime = searchTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public LocalDateTime getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(LocalDateTime searchTime) {
        this.searchTime = searchTime;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public JsonObject toJson() {
        JsonArrayBuilder recipesBuilder = Json.createArrayBuilder();
        for (Recipe recipe : recipes) {
            recipesBuilder.add(recipe.toJson());
        }
    
        return Json.createObjectBuilder()
                .add("id", id)
                .add("cuisine", cuisine)
                .add("recipes", recipesBuilder)
                .add("wine", wine.toJson())
                .add("searchTime", searchTime.toString())
                .build();
    }
    
    public static UserHistory createFromJson(String json) {
        try (StringReader strReader = new StringReader(json)) {
            JsonReader jsonReader = Json.createReader(strReader);
            return createFromJsonObject(jsonReader.readObject());
        }
    }
    
    public static UserHistory createFromJsonObject(JsonObject jsonObject) {
        UserHistory userHistory = new UserHistory();
        userHistory.setId(jsonObject.getJsonNumber("id").longValue());
        userHistory.setCuisine(jsonObject.getString("cuisine"));
    
        List<Recipe> recipeList = new ArrayList<>();
        jsonObject.getJsonArray("recipes").forEach(jsonValue -> {
            JsonObject recipeObject = jsonValue.asJsonObject();
            Recipe recipe = Recipe.createFromJsonObject(recipeObject);
            recipeList.add(recipe);
        });
        userHistory.setRecipes(recipeList);
    
        Wine wine = Wine.createFromJsonObject(jsonObject.getJsonObject("wine"));
        userHistory.setWine(wine);
    
        LocalDateTime searchTime = LocalDateTime.parse(jsonObject.getString("searchTime"));
        userHistory.setSearchTime(searchTime);
    
        return userHistory;
    }
    

}
