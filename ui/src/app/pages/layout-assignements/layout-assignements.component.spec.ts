import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutAssignementsComponent } from './layout-assignements.component';

describe('LayoutAssignementsComponent', () => {
  let component: LayoutAssignementsComponent;
  let fixture: ComponentFixture<LayoutAssignementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutAssignementsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutAssignementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
