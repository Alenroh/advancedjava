import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {

  private apiUrl = 'http://localhost:8080/api/welcome';

  constructor(private http: HttpClient) { }

  getWelcomeMessage(language: string): Observable<string> {
    return this.http.get(this.apiUrl, { headers: { 'Accept-Language': language }, responseType: 'text' });
  }
}
