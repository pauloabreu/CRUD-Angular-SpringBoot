import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { CoursesService } from '../../services/courses.service';
import { Course } from '../../model/course';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent {

  form = this.formBuilder.group({
    _id: [''],
    name: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(20)]],
    category: ['', [Validators.required]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CoursesService,
    private _snackBar: MatSnackBar,
    private Location: Location,
    private route: ActivatedRoute
  ){
    const course: Course = this.route.snapshot.data['course'];
    this.form.setValue({_id:course._id, name: course.name, category: course.category});
  }

  onSubmit(){
    this.service.save(this.form.value)
      .subscribe({
        next: () => this.onSuccess(),
        error: (error) => {
          this.onError(error.message);
        }
      });
  }

  onCancel(){
    this.Location.back();
  }

  private onSuccess(){
    this._snackBar.open("Saved!", "", {duration:5000});
    this.Location.back();
  }

  private onError(message: string){
    this._snackBar.open(message, "Close", {duration:2000});
  }

  public getErrorMessage(fieldName: string){
    const field = this.form.get(fieldName);

    if (field?.hasError('required')){
      return "Field is required!"
    }

    if (field?.hasError('minlength')){
      const requiredLength = field.errors ? field.errors['minlength']['requiredLength'] : 5;
      return `Field minimum length are ${requiredLength}!`
    }

    if (field?.hasError('maxlength')){
      const requiredLength = field.errors ? field.errors['maxlength']['requiredLength'] : 20;
      return `Field maximum length are ${requiredLength}!`
    }

    return 'Invalid Field';
  }

}
