package sg.nus.iss.miniprojectserver.models;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private String id;

    // @Column(nullable = false)
    // private String name;

    // @Column(nullable=false, unique = true)
    // private String email;

    // @Column(nullable = false)
    // private String password;

    // @Column(nullable = false)
    // private Integer contactNumber;

    // @Column(nullable = false, unique = true)
    // private String username; //might delete and use email as username

    // public String getId() {
    //     return id;
    // }

    // public void setId(String id) {
    //     this.id = id;
    // }

    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
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

    // public Integer getContactNumber() {
    //     return contactNumber;
    // }

    // public void setContactNumber(Integer contactNumber) {
    //     this.contactNumber = contactNumber;
    // }

    // public String getUsername() {
    //     return username;
    // }

    // public void setUsername(String username) {
    //     this.username = username;
    // }

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(
    //     name="users_roles",
    //     joinColumns={@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
    //     inverseJoinColumns = {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    //     private List<Roles> roles = new ArrayList<>();

    // public List<Roles> getRoles() {
    //     return roles;
    // }

    // public void setRoles(List<Roles> roles) {
    //     this.roles = roles;
    // }
        
    
     

    
}
