import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignationListComponent } from './assignation-list.component';

describe('AssignationListComponent', () => {
  let component: AssignationListComponent;
  let fixture: ComponentFixture<AssignationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignationListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssignationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
