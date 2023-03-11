import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutHospitalComponent } from './layout-hospital.component';

describe('LayoutHospitalComponent', () => {
  let component: LayoutHospitalComponent;
  let fixture: ComponentFixture<LayoutHospitalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutHospitalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutHospitalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
