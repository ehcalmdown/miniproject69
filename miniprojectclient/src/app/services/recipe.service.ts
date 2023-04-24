import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Recipe } from '../components/models/models';
import { UserHistory } from '../components/models/models';

@Injectable({
  providedIn: 'root',
})
export class RecipeService {
  private baseUrl = '/recipeapp';

  constructor(private http: HttpClient) {}

  getRecipes(cuisine: string) {
    return this.http.get<Recipe[]>(`${this.baseUrl}/recipes?cuisine=${cuisine}`);
  }

  getWinePairing(cuisine: string) {
    return this.http.get<string>(`${this.baseUrl}/wine?cuisine=${cuisine}`);
  }

  getUserHistory(userId: number) {
    return this.http.get<UserHistory[]>(`${this.baseUrl}/history/${userId}`);
  }

  saveUserHistory(userHistory: UserHistory) {
    return this.http.post<UserHistory>(`${this.baseUrl}/history`, userHistory);
  }

  updateUserHistory(id: number, userHistory: UserHistory) {
    return this.http.put<UserHistory>(`${this.baseUrl}/history/${id}`, userHistory);
  }
}
