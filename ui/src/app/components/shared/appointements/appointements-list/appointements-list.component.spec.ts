import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointementsListComponent } from './appointements-list.component';

describe('AppointementsListComponent', () => {
  let component: AppointementsListComponent;
  let fixture: ComponentFixture<AppointementsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointementsListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppointementsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
