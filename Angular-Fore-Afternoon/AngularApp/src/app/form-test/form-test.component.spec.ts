import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormTestComponent } from './form-test.component';
import { MatMenuModule } from '@angular/material/menu';

describe('FormTestComponent', () => {
  let component: FormTestComponent;
  let fixture: ComponentFixture<FormTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormTestComponent],
      imports: [
        MatMenuModule,
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
