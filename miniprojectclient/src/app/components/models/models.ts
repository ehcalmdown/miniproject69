export interface Recipe {
    id: number;
    name: string;
    ingredients: string;
    steps: string;
    cuisine: string;
  }
  


  export interface UserHistory {
    id: number;
    userId: number;
    recipeId: number;
  }


  