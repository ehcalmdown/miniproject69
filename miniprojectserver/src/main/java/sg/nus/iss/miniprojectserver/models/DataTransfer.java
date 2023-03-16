package sg.nus.iss.miniprojectserver.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DataTransfer { //helps transfer data between different layers of application,contains fields that need transfer
    private Long id;
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty(message = "cannot be empty")
    @Email
    private String email;

    @NotEmpty(message = "cannot be empty")
    private String password;
    
}
