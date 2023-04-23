package sg.nus.iss.miniprojectserver.models;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String cuisine;
    @ElementCollection
    private List<String> ingredients;
    private String instructions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_history_id")
    private UserHistory userHistory;

    public Recipe() {
    }

    public Recipe(Long id, String title, String image, String cuisine, List<String> ingredients, String instructions, UserHistory userHistory) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.userHistory = userHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public JsonObject toJson() {
        JsonArrayBuilder ingredientsBuilder = Json.createArrayBuilder();
        for (String ingredient : ingredients) {
            ingredientsBuilder.add(ingredient);
        }
    
        return Json.createObjectBuilder()
                .add("id", id)
                .add("title", title)
                .add("image", image)
                .add("cuisine", cuisine)
                .add("ingredients", ingredientsBuilder)
                .add("instructions", instructions)
                .build();
    }
    
    public static Recipe createFromJson(String json) {
        try (StringReader strReader = new StringReader(json)) {
            JsonReader jsonReader = Json.createReader(strReader);
            return createFromJsonObject(jsonReader.readObject());
        }
    }
    
    public static Recipe createFromJsonObject(JsonObject jsonObject) {
        Recipe recipe = new Recipe();
        recipe.setId(jsonObject.getJsonNumber("id").longValue());
        recipe.setTitle(jsonObject.getString("title"));
        recipe.setImage(jsonObject.getString("image"));
        recipe.setCuisine(jsonObject.getString("cuisine"));
    
        JsonArray ingredientsArray = jsonObject.getJsonArray("ingredients");
        List<String> ingredientsList = new ArrayList<>();
        for (int i = 0; i < ingredientsArray.size(); i++) {
            ingredientsList.add(ingredientsArray.getString(i));
        }
        recipe.setIngredients(ingredientsList);
    
        recipe.setInstructions(jsonObject.getString("instructions"));
    
        return recipe;
    }
    
    
}

