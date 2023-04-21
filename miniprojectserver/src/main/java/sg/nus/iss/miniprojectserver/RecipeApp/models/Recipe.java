package sg.nus.iss.miniprojectserver.RecipeApp.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;


@Entity
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