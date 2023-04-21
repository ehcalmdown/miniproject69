package sg.nus.iss.miniprojectserver.RecipeApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WinePairingResponse {
    private String winePairingText;
}