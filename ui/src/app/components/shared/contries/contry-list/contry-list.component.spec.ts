import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContryListComponent } from './contry-list.component';

describe('ContryListComponent', () => {
  let component: ContryListComponent;
  let fixture: ComponentFixture<ContryListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContryListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
