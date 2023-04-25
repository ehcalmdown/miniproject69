import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { loadStripe, Stripe } from '@stripe/stripe-js';
import { firstValueFrom } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class StripeService {
    stripePromise: Promise<Stripe | null>;

    constructor(private http: HttpClient) {
        this.stripePromise = loadStripe('pk_test_51N0UpIJYoVwUPlBXpvA16FK6fq0WCGlDSim2KcWAXb7Ru8zfyigxqcL98LryXJxVXk5NGNqf8QCZB1HDyfD6hRvq00wPaq32X5');
    }

    async redirectToCheckout() {
        const stripe = await this.stripePromise;
        const session = await this.createCheckoutSession();

        if (stripe && session) {
            await stripe.redirectToCheckout({ sessionId: session.id });
        }
    }

    private async createCheckoutSession(): Promise<{ id: string }> {
      const response = await firstValueFrom(
        this.http.post<{ id: string }>('/stripe/create-checkout-session', {})
      );
      
      if (response) {
        return response;
      } else {
        throw new Error('Checkout session is undefined');
      }
    }
    
    
}
