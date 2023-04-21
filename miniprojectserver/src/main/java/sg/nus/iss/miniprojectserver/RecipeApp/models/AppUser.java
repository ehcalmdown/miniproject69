package sg.nus.iss.miniprojectserver.RecipeApp.models;

import java.util.List;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    
        private Long id;
        private String username;
        private String password;
        private List<UserHistory> searchHistory;
    
}
