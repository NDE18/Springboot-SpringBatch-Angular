import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(environment.baseUrl+"/all");
  }

  get(id: any): Observable<User> {
    return this.http.get<User>(`${environment.baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(environment.baseUrl+"/create", data);
  }
}
