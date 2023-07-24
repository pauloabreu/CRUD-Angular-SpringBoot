import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from './app-material/app-material.module';
import { ErrorDiologComponent } from './components/error-diolog/error-diolog.component';
import { CategoryPipe } from './pipes/category.pipe';

@NgModule({
  declarations: [
    ErrorDiologComponent,
    CategoryPipe
  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ],
  exports:[
    ErrorDiologComponent,
    CategoryPipe
  ]
})
export class SharedModule { }
