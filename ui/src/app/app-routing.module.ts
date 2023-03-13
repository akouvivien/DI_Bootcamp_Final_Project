import { NotFoundComponent } from './pages/not-found/not-found.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path:'authentification',
    loadChildren: () => import('./components/auth/auth.module').then(m=>m.AuthModule)
  },

  {
    path:'layout',
    loadChildren: () => import('./pages/layout.module').then(m=>m.LayoutModule)

  },

  {
    path:'',
    redirectTo:'authentification',
    pathMatch: 'full'
  },

  { path:'**',component:NotFoundComponent }


];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
