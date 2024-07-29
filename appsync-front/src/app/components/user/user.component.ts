import { Component } from '@angular/core';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  user: User = {
    lastName: "",
    firstName: "",
    birth: "",
    email: "",
    phone: "",
  };
  submitted = false;

  constructor(private userService: UserService) {}

  saveUser(): void {
    const data = {
      id:5,
      lastName: this.user.lastName,
      firstName: this.user.firstName,
      birth: this.user.birth,
      email: this.user.email,
      phone: this.user.phone,
    };

    this.userService.create(data).subscribe({
      next: (res) => {
        console.log(res);
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
    console.log(data);
  }

  newUser(): void {
    this.submitted = false;
    this.user = {
      lastName: "",
      firstName: "",
      birth: "",
      email: "",
      phone: "",
    };
  }
}
