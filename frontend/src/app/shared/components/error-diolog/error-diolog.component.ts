import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-error-diolog',
  templateUrl: './error-diolog.component.html',
  styleUrls: ['./error-diolog.component.scss']
})
export class ErrorDiologComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: string) {}
}
