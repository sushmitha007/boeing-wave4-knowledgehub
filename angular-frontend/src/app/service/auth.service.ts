import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { userInfo } from '../domain/login-info';
import { Observable } from 'rxjs';
import { JwtResponse } from '../domain/jwt-response';
import { TokenService } from './token.service';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = 'http://13.234.94.132:8092/login-service/api/auth/signin';
  private url2 = 'http://13.234.94.132:8092/login-service/api/test/user';

  constructor(private http: HttpClient, private token: TokenService) { }
  //This method is to post login credentials to backend and get response.
  auth(credentials: userInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.url, credentials, httpOptions)
  }
}
