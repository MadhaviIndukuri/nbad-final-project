import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { ContentService } from '../services/content.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, MatCardModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {
  articles: any[] = [];

  constructor(private contentService: ContentService, private router: Router) {
    this.fetchArticles();
  }

  fetchArticles() {
    this.contentService.fetchArticles().subscribe(data => {
      this.articles = data;
    });
  }

  navigateToSummary(article: any) {
    this.router.navigate(['/summary'], { state: { article } });
  }
}
