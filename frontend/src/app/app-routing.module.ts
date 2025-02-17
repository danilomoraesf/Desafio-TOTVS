import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComentarioComponent } from './comentarios/cadastro-comentario/cadastro-comentario.component';
import { CadastroPaisesComponent } from './paises/cadastro-paises/cadastro-paises.component';
import { PaisesComponent } from './paises/paises.component';
import { CadastroPontosTuristicosComponent } from './pontos-turisticos/cadastro-pontos-turisticos/cadastro-pontos-turisticos.component';
import { PontosTuristicosComponent } from './pontos-turisticos/pontos-turisticos.component';

const routes: Routes = [
  {
    path: 'pais',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: PaisesComponent
      },
      {
        path: 'cadastro',
        children: [
          {
            path: ':idPais',
            component: CadastroPaisesComponent,
            data: { tipoCadastroPais: '' }
          },
          {
            path: '',
            pathMatch: 'full',
            component: CadastroPaisesComponent,
            data: { tipoCadastroPais: 'new' }
          }
        ]
      }
    ]
  },
  {
    path: 'ponto-turistico',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: PontosTuristicosComponent,
      },
      {
        path: 'cadastro/:idPontoTuristico/comentario/:idComentario',
        component: CadastroComentarioComponent,
        data: { tipoCadastroComentario: 'view' }
      },
      {
        path: 'cadastro/:idPontoTuristico/comentario',
        component: CadastroComentarioComponent,
        data: { tipoCadastroComentario: 'view' }
      },
      {
        path: 'cadastro',
        children:[
          {
            path: '',
            pathMatch: 'full',
            component: CadastroPontosTuristicosComponent,
            data: { tipoCadastroPontoTuristico: 'new' }
          },
          {
            path: ':idPontoTuristico',
            component: CadastroPontosTuristicosComponent,
            data: { tipoCadastroPontoTuristico: 'view' },
          }
        ]
      },
      
    ]
  },
  {
    path: "**",
    redirectTo: "pais"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
