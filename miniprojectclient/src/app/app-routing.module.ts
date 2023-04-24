import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { RecipeListComponent } from './components/recipe-list/recipe-list.component';
import { AuthGuard } from './services/auth.guard';
import { WinePairingComponent } from './components/wine-pairing/wine-pairing.component';
import { UserHistoryComponent } from './components/user-history/user-history.component';
import { SuccessComponent } from './components/success/success.component';
import { CancelComponent } from './components/cancel/cancel.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/register', component: RegisterComponent },
  { path: 'recipeapp/**', component: RecipeListComponent, canActivate:[AuthGuard], data: { isAdmin: true }},
  { path: 'recipeapp/recipes', component: RecipeListComponent, canActivate:[AuthGuard], data: { isAdmin: true }},
  { path: 'recipeapp/wine-pairing', component: WinePairingComponent, canActivate:[AuthGuard], data: { isAdmin: true } },
  { path: 'recipeapp/user-history', component: UserHistoryComponent, canActivate:[AuthGuard], data: { isAdmin: true } },
  { path: 'stripe/success', component: SuccessComponent },
  { path: 'stripe/cancel', component: CancelComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
