package sg.nus.iss.miniprojectserver.models;

import java.time.LocalDateTime;
import java.util.List;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
// @Data
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
public class UserHistory {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String cuisine;

    @OneToMany(mappedBy = "userHistory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Recipe> recipes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id")
    private Wine wine;

    private LocalDateTime searchTime;

    public UserHistory() {
    }

    public UserHistory(Long id, String cuisine, List<Recipe> recipes, Wine wine, LocalDateTime searchTime) {
        this.id = id;
        this.cuisine = cuisine;
        this.recipes = recipes;
        this.wine = wine;
        this.searchTime = searchTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(Wine wine) {
        this.wine = wine;
    }

    public LocalDateTime getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(LocalDateTime searchTime) {
        this.searchTime = searchTime;
    }

}
