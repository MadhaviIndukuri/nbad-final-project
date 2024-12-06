import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BaseChartDirective } from 'ng2-charts';
import { ChartConfiguration, ChartType } from 'chart.js';
import { ContentService } from '../services/content.service';

@Component({
  selector: 'app-summary',
  standalone: true,
  imports: [CommonModule, BaseChartDirective],
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.scss']
})
export class SummaryComponent {
  article: any;
  chartData: ChartConfiguration['data'] = {
    datasets: [
      {
        data: [],
        label: 'Series A'
      }
    ],
    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July']
  };

  chartOptions: ChartConfiguration['options'] = {
    responsive: true
  };

  chartType: ChartType = 'line';

  constructor(private router: Router, private contentService: ContentService) {
    const navigation = this.router.getCurrentNavigation();
    this.article = navigation?.extras.state?.['article'];
    this.fetchChartData();
  }

  fetchChartData() {
    this.contentService.fetchChartData().subscribe(data => {
      console.log('Fetched chart data:', data); // Add this line
      this.chartData.datasets[0].data = data;
    });
  }
}
