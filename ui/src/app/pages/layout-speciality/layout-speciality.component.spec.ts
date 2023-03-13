import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutSpecialityComponent } from './layout-speciality.component';

describe('LayoutSpecialityComponent', () => {
  let component: LayoutSpecialityComponent;
  let fixture: ComponentFixture<LayoutSpecialityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutSpecialityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutSpecialityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
