import { Component, OnInit } from '@angular/core';
import { UserHistory } from '../models/models';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-user-history',
  templateUrl: './user-history.component.html',
  styleUrls: ['./user-history.component.css'],
})
export class UserHistoryComponent implements OnInit {
  userHistory: UserHistory[] = [];

  constructor(private recipeService: RecipeService) {}

  ngOnInit(): void {
    this.recipeService.getUserHistory(1).subscribe((userHistory) => {
      this.userHistory = userHistory;
    });
  }
}

