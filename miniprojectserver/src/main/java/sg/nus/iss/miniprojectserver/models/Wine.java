package sg.nus.iss.miniprojectserver.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.IDENTITY;

//HIBERNATE ISSUES, HAVE TO REMOVE LOMBOK FOR TRIAL AND ERROR
// @Setter
// @Getter
// @Data
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
public class Wine {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;
    private String password;
    private List<UserHistory> searchHistory;

    public Wine() {
    }

    public Wine(Long id, String username, String password, List<UserHistory> searchHistory) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.searchHistory = searchHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserHistory> getSearchHistory() {
        return searchHistory;
    }

    public void setSearchHistory(List<UserHistory> searchHistory) {
        this.searchHistory = searchHistory;
    }
    
}
