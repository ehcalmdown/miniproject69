import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';

interface LoginResponse {
  token: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly TOKEN_KEY = 'auth_token';
  private isAuthenticatedSubject = new BehaviorSubject<boolean>(this.hasToken());

  constructor(private http: HttpClient,
              private router: Router) {}

  isAuthenticated(): Observable<boolean> {
    return this.isAuthenticatedSubject.asObservable();
  }

  login(username: string, password: string): Observable<LoginResponse> {
    const body = { username, password };
    return this.http.post<LoginResponse>('/auth/login', body).pipe(
      tap(response => {
        localStorage.setItem(this.TOKEN_KEY, response.token);
        this.isAuthenticatedSubject.next(true);
      })
    );
  }

  logout(){
    localStorage.removeItem("email")
    localStorage.removeItem("token")
    localStorage.removeItem("role")
    this.router.navigate(['/auth/login'])
 }

  getToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  private hasToken(): boolean {
    return !!localStorage.getItem(this.TOKEN_KEY);
  }
}
