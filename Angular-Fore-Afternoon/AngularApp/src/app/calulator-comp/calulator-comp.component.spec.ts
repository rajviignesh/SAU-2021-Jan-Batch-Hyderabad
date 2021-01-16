import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalulatorCompComponent } from './calulator-comp.component';

describe('CalulatorCompComponent', () => {
  let component: CalulatorCompComponent;
  let fixture: ComponentFixture<CalulatorCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalulatorCompComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CalulatorCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
