package sg.nus.iss.miniprojectserver.models;

import java.util.List;

// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;
//REMOVED LOMBOK FOR TRIAL AND ERROR

// @Data
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
public class RecipeResponse {
    private List<Recipe> results;

    public RecipeResponse() {
    }

    public RecipeResponse(List<Recipe> results) {
        this.results = results;
    }

    public List<Recipe> getResults() {
        return results;
    }

    public void setResults(List<Recipe> results) {
        this.results = results;
    }
}








