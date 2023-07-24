import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDiologComponent } from 'src/app/shared/components/error-diolog/error-diolog.component';

import { Course } from '../model/course';
import { CoursesService } from './../services/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent{

  displayedColumns = ['name', 'category'];
  courses$: Observable<Course[]>;

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog
  ){
    this.courses$ = this.coursesService.list()
    .pipe(
      catchError(error => {
        this.onError(error.message);
        return of([])
      })
    );
  }


  onError(errorMsg: string) {
    this.dialog.open(ErrorDiologComponent, {
      data: errorMsg
    });
  }

}
