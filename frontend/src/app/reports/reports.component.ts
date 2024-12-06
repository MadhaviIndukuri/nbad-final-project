import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContentService } from '../services/content.service';

@Component({
  selector: 'app-reports',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './reports.component.html',
  styleUrl: './reports.component.scss'
})
export class ReportsComponent {
  reports: any[] = [];

  constructor(private contentService: ContentService) {
    this.fetchReports();
  }

  fetchReports() {
    this.contentService.fetchReports().subscribe(data => {
      this.reports = data;
    });
  }
}
