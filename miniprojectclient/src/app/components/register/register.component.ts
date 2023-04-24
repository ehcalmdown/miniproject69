import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private userService: UserService, private router: Router) { }

  register(username: string, email: string, password: string): void {
    this.userService.register(username, email, password).subscribe(response => {

      this.router.navigate(['/login']); // redirect the user to the login page after successful registration
    }, error => {
      console.error('Registration error:', error);
    });
  }
}
