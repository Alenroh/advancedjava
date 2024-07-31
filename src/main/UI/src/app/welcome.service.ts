import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WelcomeService {
  private readonly baseURL: string = 'http://localhost:8080';
  private readonly welcomeUrl: string = `${this.baseURL}/welcome`;
  private readonly announceUrl: string = `${this.baseURL}/announce`;

  constructor(private httpClient: HttpClient) {}

  getWelcomeMessage(language: string): Observable<string> {
    return this.httpClient.get(`${this.welcomeUrl}?lang=${language}`, { responseType: 'text' });
  }

  getAnnouncePresentation(): Observable<string> {
    return this.httpClient.get(`${this.announceUrl}`, { responseType: 'text' });
  }
}
