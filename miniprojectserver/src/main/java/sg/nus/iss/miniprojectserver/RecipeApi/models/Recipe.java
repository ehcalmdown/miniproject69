package sg.nus.iss.miniprojectserver.RecipeApi.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private Long id;
    private String title;
    private String image;
    private String cuisine;
    private List<String> ingredients;
    private String instructions;
    
}
