package sg.nus.iss.miniprojectserver.RecipeApp.models;

import java.time.LocalDateTime;
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
public class UserHistory {
    private Long id;
    private String cuisine;
    private List<Recipe> recipes;
    private Wine wine;
    private LocalDateTime searchTime;
    
}