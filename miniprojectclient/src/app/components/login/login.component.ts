import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private userService: UserService, private router: Router) { }

  login(username: string, password: string): void {
    this.userService.login(username, password).subscribe(response => {
      // handle successful login
      localStorage.setItem('token', response.token);
      this.router.navigate(['/recipeapp/recipe']); // navigate to desired page, might have to change a few times since jj's dumbass cant understand this part
    }, error => {
      console.error('Login error:', error);
    });
  }
}
