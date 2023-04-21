package sg.nus.iss.miniprojectserver.Security.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    
    


    
    // public RegRequest(String email, String password, String role, String name) {
    //     this.email = email;
    //     this.password = password;
    //     this.role = role;
    //     this.name = name;
    // }
    
    
    // public String getEmail() {
    //     return email;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }
    // public String getPassword() {
    //     return password;
    // }
    // public void setPassword(String password) {
    //     this.password = password;
    // }
    // public String getRole() {
    //     return role;
    // }
    // public void setRole(String role) {
    //     this.role = role;
    // }
    //  public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    
}
