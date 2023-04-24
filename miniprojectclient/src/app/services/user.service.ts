import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    const body = { username, password };
    return this.http.post('/auth/login', body);
  }

  register(username: string, email: string, password: string): Observable<any> {
    const body = { username, email, password };
    return this.http.post('/auth/register', body);
  }
}
