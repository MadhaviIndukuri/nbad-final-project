import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ContentService {
  private baseUrl = environment.apiUrl;

  constructor(private http: HttpClient, private authService: AuthService) {}

  private getAuthHeaders(): HttpHeaders {
    const token = this.authService.getToken();
    return new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
  }

  fetchArticles(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/api/dashboard`, { headers: this.getAuthHeaders() });
  }

  fetchReports(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/api/reports`, { headers: this.getAuthHeaders() });
  }

  fetchChartData(): Observable<number[]> {
    return this.http.get<number[]>(`${this.baseUrl}/api/chart-data`, { headers: this.getAuthHeaders() });
  }
}
