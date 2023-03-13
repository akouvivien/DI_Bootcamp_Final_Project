import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutRoleComponent } from './layout-role.component';

describe('LayoutRoleComponent', () => {
  let component: LayoutRoleComponent;
  let fixture: ComponentFixture<LayoutRoleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LayoutRoleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LayoutRoleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
