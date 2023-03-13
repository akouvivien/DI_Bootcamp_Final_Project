import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutContryComponent } from './layout-contry.component';

describe('LayoutContryComponent', () => {
  let component: LayoutContryComponent;
  let fixture: ComponentFixture<LayoutContryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutContryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutContryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
