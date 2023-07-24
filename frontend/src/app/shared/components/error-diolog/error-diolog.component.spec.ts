import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErrorDiologComponent } from './error-diolog.component';

describe('ErrorDiologComponent', () => {
  let component: ErrorDiologComponent;
  let fixture: ComponentFixture<ErrorDiologComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ErrorDiologComponent]
    });
    fixture = TestBed.createComponent(ErrorDiologComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
