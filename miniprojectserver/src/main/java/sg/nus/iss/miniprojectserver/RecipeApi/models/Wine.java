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
public class Wine {
    private Long id;
    private String username;
    private String password;
    private List<UserHistory> searchHistory;
    
}
