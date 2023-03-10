import { TestBed } from '@angular/core/testing';
import { IsConnectedGuard } from './is-guard';


describe('IsConnectedGuard', () => {
  let guard: IsConnectedGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(IsConnectedGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
