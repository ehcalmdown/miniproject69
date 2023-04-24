import { Component, OnInit } from '@angular/core';
import { RecipeService } from 'src/app/services/recipe.service';


@Component({
  selector: 'app-wine-pairing',
  templateUrl: './wine-pairing.component.html',
  styleUrls: ['./wine-pairing.component.css'],
})
export class WinePairingComponent implements OnInit {
  winePairing = '';

  constructor(private recipeService: RecipeService) {}

  ngOnInit(): void {
    this.recipeService.getWinePairing('Italian').subscribe((winePairing) => {
      this.winePairing = winePairing;
    });
  }
}


