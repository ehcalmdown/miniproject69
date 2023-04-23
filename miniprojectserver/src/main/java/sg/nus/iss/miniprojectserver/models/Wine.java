package sg.nus.iss.miniprojectserver.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
import jakarta.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private String pairingText;
public Wine() {
}

public Wine(String name, String description, String image, String pairingText) {
    this.name = name;
    this.description = description;
    this.image = image;
    this.pairingText = pairingText;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public String getImage() {
    return image;
}

public void setImage(String image) {
    this.image = image;
}

public String getPairingText() {
    return pairingText;
}

public void setPairingText(String pairingText) {
    this.pairingText = pairingText;
}

public JsonObject toJson() {
    return Json.createObjectBuilder()
            .add("id", id)
            .add("name", name)
            .add("description", description)
            .add("image", image)
            .add("pairingText", pairingText)
            .build();
}

public static Wine createFromJson(String json) {
    try (StringReader strReader = new StringReader(json)) {
        JsonReader jsonReader = Json.createReader(strReader);
        return createFromJsonObject(jsonReader.readObject());
    }
}

public static Wine createFromJsonObject(JsonObject jsonObject) {
    Wine wine = new Wine();
    wine.setId(jsonObject.getJsonNumber("id").longValue());
    wine.setName(jsonObject.getString("name"));
    wine.setDescription(jsonObject.getString("description"));
    wine.setImage(jsonObject.getString("image"));
    wine.setPairingText(jsonObject.getString("pairingText"));

    return wine;
}


}

