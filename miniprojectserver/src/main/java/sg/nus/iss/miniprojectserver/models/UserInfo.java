package sg.nus.iss.miniprojectserver.models;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @Setter
// @Getter
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String roles;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserHistory> searchHistory;

    public UserInfo() {
    }

    public UserInfo(int id, String name, String email, String password, String roles, List<UserHistory> searchHistory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.searchHistory = searchHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<UserHistory> getSearchHistory() {
        return searchHistory;
    }

    public void setSearchHistory(List<UserHistory> searchHistory) {
        this.searchHistory = searchHistory;
    }


    public JsonObject toJson() {
        JsonArrayBuilder searchHistoryBuilder = Json.createArrayBuilder();
        for (UserHistory userHistory : searchHistory) {
            searchHistoryBuilder.add(userHistory.toJson());
        }
    
        return Json.createObjectBuilder()
                .add("id", id)
                .add("name", name)
                .add("email", email)
                .add("password", password)
                .add("roles", roles)
                .add("searchHistory", searchHistoryBuilder)
                .build();
    }
    
    public static UserInfo createFromJson(String json) {
        try (StringReader strReader = new StringReader(json)) {
            JsonReader jsonReader = Json.createReader(strReader);
            return createFromJsonObject(jsonReader.readObject());
        }
    }
    
    public static UserInfo createFromJsonObject(JsonObject jsonObject) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(jsonObject.getInt("id"));
        userInfo.setName(jsonObject.getString("name"));
        userInfo.setEmail(jsonObject.getString("email"));
        userInfo.setPassword(jsonObject.getString("password"));
        userInfo.setRoles(jsonObject.getString("roles"));
    
        List<UserHistory> userHistoryList = new ArrayList<>();
        jsonObject.getJsonArray("searchHistory").forEach(jsonValue -> {
            JsonObject historyObject = jsonValue.asJsonObject();
            UserHistory userHistory = UserHistory.createFromJsonObject(historyObject);
            userHistoryList.add(userHistory);
        });
        userInfo.setSearchHistory(userHistoryList);
    
        return userInfo;
    }
    
    
}

