import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutAppointementsComponent } from './layout-appointements.component';

describe('LayoutAppointementsComponent', () => {
  let component: LayoutAppointementsComponent;
  let fixture: ComponentFixture<LayoutAppointementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutAppointementsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutAppointementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
