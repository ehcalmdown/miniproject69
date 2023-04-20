import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RecipeSearchComponent } from './recipesearch/recipesearch.component';
import { RecipeListComponent } from './recipelist/recipelist.component';

const routes: Routes = [
  { path: '', redirectTo: '/recipe-search', pathMatch: 'full' },
  { path: 'recipe-search', component: RecipeSearchComponent },
  { path: 'recipe-list', component: RecipeListComponent },
  { path: '', redirectTo: '/recipe-search', pathMatch: 'full' },
  // Add other routes here as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}