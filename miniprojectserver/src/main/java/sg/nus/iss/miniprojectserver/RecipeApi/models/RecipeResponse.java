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
public class RecipeResponse {
    private List<Recipe> results;
}
