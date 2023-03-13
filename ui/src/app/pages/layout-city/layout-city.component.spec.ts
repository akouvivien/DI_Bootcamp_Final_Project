import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutCityComponent } from './layout-city.component';

describe('LayoutCityComponent', () => {
  let component: LayoutCityComponent;
  let fixture: ComponentFixture<LayoutCityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutCityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
