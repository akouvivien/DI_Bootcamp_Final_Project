import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutMunicipalityComponent } from './layout-municipality.component';

describe('LayoutMunicipalityComponent', () => {
  let component: LayoutMunicipalityComponent;
  let fixture: ComponentFixture<LayoutMunicipalityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutMunicipalityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutMunicipalityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
