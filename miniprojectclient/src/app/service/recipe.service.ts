import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipe } from '../models/Recipe';
import { WinePairing } from '../models/WinePairing';

@Injectable({
  providedIn: 'root',
})
export class RecipeService {
  private apiUrl = 'http://localhost:8080/api/recipes';

  constructor(private http: HttpClient) {}

  searchRecipes(cuisine: string): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(`${this.apiUrl}/search?cuisine=${cuisine}`);
  }

  getWinePairing(cuisine: string): Observable<WinePairing> {
    return this.http.get<WinePairing>(`${this.apiUrl}/wine-pairing?cuisine=${cuisine}`);
  }
}


