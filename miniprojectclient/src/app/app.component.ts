import { Component, OnInit } from '@angular/core';
import { loadStripe } from '@stripe/stripe-js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'miniprojectclient';
  stripe: any;

  async ngOnInit() {
    this.stripe = await loadStripe('pk_test_51N0UpIJYoVwUPlBXpvA16FK6fq0WCGlDSim2KcWAXb7Ru8zfyigxqcL98LryXJxVXk5NGNqf8QCZB1HDyfD6hRvq00wPaq32X5');
  }

  async handleDonate() {
    if (this.stripe) {
      const response = await fetch('/stripe/create-checkout-session', {
        method: 'POST'
      });
      const session = await response.json();
      await this.stripe.redirectToCheckout({ sessionId: session.id });
    } else {
      console.error('Stripe is not loaded');
    }
  }
}
