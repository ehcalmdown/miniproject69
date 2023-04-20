import { Component, Input } from '@angular/core';
import { Recipe } from '../models/Recipe';

@Component({
  selector: 'app-recipe-list',
  templateUrl: '../recipe-list.component.html',
})
export class RecipeListComponent {
  @Input() recipes: Recipe[];
}

