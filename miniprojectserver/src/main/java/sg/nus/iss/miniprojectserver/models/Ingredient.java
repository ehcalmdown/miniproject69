// package sg.nus.iss.miniprojectserver.models;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;


// // @Setter
// // @Getter
// @Entity
// // @Data
// // @Builder
// // @AllArgsConstructor
// // @NoArgsConstructor
// public class Ingredient {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @ManyToOne
//     private Recipe recipe;

//     public Ingredient() {
//     }

//     public Ingredient(Long id, String name, Recipe recipe) {
//         this.id = id;
//         this.name = name;
//         this.recipe = recipe;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public Recipe getRecipe() {
//         return recipe;
//     }

//     public void setRecipe(Recipe recipe) {
//         this.recipe = recipe;
//     }

//     @Override
//     public String toString() {
//         return "Ingredient{" +
//                 "id=" + id +
//                 ", name='" + name + '\'' +
//                 '}';
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (o == null || getClass() != o.getClass()) return false;

//         Ingredient that = (Ingredient) o;

//         if (id != null ? !id.equals(that.id) : that.id != null) return false;
//         return name != null ? name.equals(that.name) : that.name == null;
//     }

//     @Override
//     public int hashCode() {
//         int result = id != null ? id.hashCode() : 0;
//         result = 31 * result + (name != null ? name.hashCode() : 0);
//         return result;
//     }
// }
