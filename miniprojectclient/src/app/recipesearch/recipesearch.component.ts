import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { RecipeService } from '../service/recipe.service';

@Component({
  selector: 'app-recipe-search',
  templateUrl: './recipe-search/recipe-search.component.html',
})
export class RecipeSearchComponent {
  cuisineForm: FormGroup;

  constructor(private fb: FormBuilder, private recipeService: RecipeService) {
    this.cuisineForm = this.fb.group({
      cuisine: [''],
    });
  }

  onSubmit() {
    this.recipeService.searchRecipes(this.cuisineForm.value.cuisine).subscribe((recipes) => {
      console.log(recipes);
    });
  }
}
