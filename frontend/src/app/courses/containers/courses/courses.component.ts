import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErrorDiologComponent } from 'src/app/shared/components/error-diolog/error-diolog.component';

import { Course } from '../../model/course';
import { CoursesService } from '../../services/courses.service';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent{


  courses$: Observable<Course[]> | null = null;

  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private _snackBar: MatSnackBar
  ){
    this.refresh();
  }

  refresh(){
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

  onAdd(){
    this.router.navigate(['new'], {relativeTo:this.route});
  }

  onEdit(course: Course){
    this.router.navigate(['edit', course._id], {relativeTo:this.route});
  }

  onDelete(course: Course){

    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: "Would you like to delete this course?",
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result){
        this.coursesService.delete(course._id)
        .subscribe({
            next: () => this.onDeleteSuccess(),
            error: (error) => {
              this.onError(error.message);
            }
          });
      }
    });
  }

  private onDeleteSuccess(){
    this._snackBar.open("Deleted!", "", {duration:5000});
    this.refresh();
  }

}
