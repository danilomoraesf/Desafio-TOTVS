import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService, PoTableAction, PoTableColumn } from '@po-ui/ng-components';
import { map, tap } from 'rxjs';
import { HttpService } from '../service/http-service.service';
import { Pais } from '../paises/paises.component';

@Component({
  selector: 'app-pontos-turisticos',
  templateUrl: './pontos-turisticos.component.html',
  styleUrls: ['./pontos-turisticos.component.css']
})
export class PontosTuristicosComponent implements OnInit {
  lsActions: Array<PoTableAction> = this.carregarActions();
	lsColumns: Array<PoTableColumn> = this.carregarColunas();
	lsPontosTuristicos: Array<PontoTuristico> = []
  lPaises: Pais[] = [];

	constructor(
		private httpService: HttpService,
		private poNotification: PoNotificationService,
		private router: Router,
		private activatedRoute: ActivatedRoute) { }

	ngOnInit(): void {
		this.carregarPontosTuristicos()
	}

	carregarActions(): Array<PoTableAction> {
		return [
			{
				label: 'Editar',
				icon: 'po-icon-edit',
				action: (row: PontoTuristico)=>{ this.navegarParaCadastro(row.id) }
			},
			{
				label: 'Excluir',
				icon: 'po-icon-delete',
				action: (row: PontoTuristico)=>{ this.deletarCadastro(row.id) }
			}
		]
	}

	deletarCadastro(id: string): void {
		this.httpService.delete('pontoTuristico/' + id).subscribe({
			next: (response)=>{
				this.poNotification.success('Registro excluido com sucesso!');
				this.carregarPontosTuristicos();
			},
			error: (error)=>{
				this.poNotification.error(error);
			}
		})
	}

	navegarParaCadastro(codigoPontoTuristico: string = ""){
		this.router.navigateByUrl('/ponto-turistico/cadastro/' + codigoPontoTuristico)
	}

	carregarPontosTuristicos(){
    return this.httpService.get('pais').subscribe({
			next: (resposta)=>{
        this.lPaises = resposta;
        this.httpService.get('pontoTuristico').subscribe({
          next: (resposta)=>{
            let registros: Array<PontoTuristico> = []
            resposta.forEach(item => {
              const pais = this.lPaises.find((pais) => pais.id === item.paisId).nome
              let novoPontoTuristico: PontoTuristico = {
                id: item.id,
                nome: item.nome,
                melhorEstacao: item.melhorEstacao,
                cidade: item.cidade,
                paisId: item.paisId,
                pais
              }
              registros.push(novoPontoTuristico);
            });
    
            this.lsPontosTuristicos = [...registros]
          }
        })
			},
			error: (erro)=>{
				this.poNotification.error(erro)
			}
		})
		 
	}

	carregarColunas(): Array<PoTableColumn>{
		return [
      {
        property: 'nome',
				label: 'Nome',
			},
      {
        property: 'cidade',
        label: 'Cidade'
      },
			{
				property: 'melhorEstacao',
				label: 'Melhor Estação'
			},
			{
				property: 'pais',
				label: 'Pais'
			}
		]
	}
}

interface PontoTuristico{
	id: string,
	nome: string,
	melhorEstacao: string,
	paisId: number,
	cidade: string,
  pais?: string;
}
