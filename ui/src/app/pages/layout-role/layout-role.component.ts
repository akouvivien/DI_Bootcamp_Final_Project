import { Component, Input } from '@angular/core';
import { Roles } from 'src/app/interfaces/roles';

@Component({
  selector: 'app-layout-role',
  templateUrl: './layout-role.component.html',
  styleUrls: ['./layout-role.component.css']
})
export class LayoutRoleComponent {

 rolesList : Roles[] = [];

  ngOnInit() {
    this.rolesList
  }


  getRolesListFromRolesComponent(event: Roles[]) {
    this.rolesList = event;
  }


}
