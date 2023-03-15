import { Component, Input } from '@angular/core';
import { Roles } from 'src/app/interfaces/roles';

@Component({
  selector: 'app-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent {

  @Input() rolesList!:Roles[];

}
