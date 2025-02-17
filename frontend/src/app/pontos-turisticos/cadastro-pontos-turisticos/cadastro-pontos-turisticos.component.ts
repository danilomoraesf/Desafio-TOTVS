import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService, PoTableAction, PoTableColumn } from '@po-ui/ng-components';
import { Pais } from 'src/app/paises/paises.component';
import { HttpService } from 'src/app/service/http-service.service';


@Component({
  selector: 'app-cadastro-pontos-turisticos',
  templateUrl: './cadastro-pontos-turisticos.component.html',
  styleUrls: ['./cadastro-pontos-turisticos.component.css']
})
export class CadastroPontosTuristicosComponent implements OnInit {
  idPontoTuristico: string;
	formPontoTuristico: FormGroup;
  lPaises: Pais[] = [];
	title: string = "Novo cadastro de Ponto Turístico"
  lsComentarios: Comentario[] = [];
  lsActions: Array<PoTableAction> = this.carregarActions();
	lsColumns: Array<PoTableColumn> = this.carregarColunas();
  
	constructor(private formBuilder: FormBuilder,
		private poNotification: PoNotificationService,
		private route: ActivatedRoute,
		private router: Router,
		private http: HttpService,
    private activatedRoute: ActivatedRoute
		) { 

		this.formPontoTuristico = this.formBuilder.group({
			nome: ['', Validators.compose([Validators.required])],
			cidade: ['', Validators.compose([Validators.required])],
			melhorEstacao: ['', Validators.compose([Validators.required])],
			paisId: [, Validators.compose([Validators.required])]
		})
	}

	ngOnInit(): void {
		this.idPontoTuristico = this.route.snapshot.paramMap.get('idPontoTuristico');
    this.buscaPaises()
		if (this.idPontoTuristico !== ""){
			this.buscaDadosPontoTuristico()
			this.title = "Alteração do Ponto Turístico"
		}
	}

	salvar(){
		if (this.validarRegistro()){
			if (this.idPontoTuristico === ""){
				this.enviarPost()
			} else {
				this.enviarPut()
			}
		} else {
			this.poNotification.error("Preencha todos os campos antes de salvar as alterações!")
		}
	}

  criarComentario(){
    this.router.navigateByUrl('/ponto-turistico/cadastro/' + this.idPontoTuristico + '/comentario')
  }

  editarComentario(comentarioId: string){
    this.router.navigateByUrl('/ponto-turistico/cadastro/' + this.idPontoTuristico + '/comentario/' + comentarioId)
  }

	voltar(){
		this.router.navigate(['/ponto-turistico'], { relativeTo: this.route })
	}

	validarRegistro(): boolean{
		return this.formPontoTuristico.valid;
	}

	enviarPost(){
		this.http.post('pontoTuristico',this.formPontoTuristico.value).subscribe({
			next:(resposta) => {
				this.poNotification.success("Registro criado com sucesso!");
				this.voltar();
			},
			error:(erro) => {
				this.poNotification.error(erro)
			},
		})
	}

	enviarPut(){
		this.http.put('pontoTuristico/' + this.idPontoTuristico,this.formPontoTuristico.value).subscribe({
			next:(resposta) => {
				this.poNotification.success("Registro atualizado com sucesso!");
				this.voltar();
			},
			error:(erro) => {
				this.poNotification.error(erro)
			},
		})
	}

	buscaDadosPontoTuristico(){
		this.http.get('pontoTuristico/' + this.idPontoTuristico).subscribe({
			next: (resposta)=>{
        this.lsComentarios = resposta.comentarios.map((item) => ({...item, dataCriacao: new Date(item.dataCriacao).toLocaleString() }));
				this.formPontoTuristico.patchValue({
					nome: resposta.nome,
					cidade: resposta.cidade,
					melhorEstacao: resposta.melhorEstacao,
					paisId: resposta.paisId
				})
			},
			error: (erro)=>{
				this.poNotification.error(erro)
			}
		})
	}

  carregarActions(): Array<PoTableAction> {
		return [
			{
				label: 'Editar',
				icon: 'po-icon-edit',
				action: (row: Comentario)=>{ this.editarComentario(row.id) }
			},
			{
				label: 'Excluir',
				icon: 'po-icon-delete',
				action: (row: Comentario)=>{ this.deletarCadastro(row.id) }
			}
		]
	}

	deletarCadastro(id: string): void {
		this.http.delete('comentario/' + id).subscribe({
			next: (response)=>{
				this.poNotification.success('Comentário excluido com sucesso!');
				this.buscaDadosPontoTuristico();
			},
			error: (error)=>{
				this.poNotification.error(error);
			}
		})
	}

	navegarParaCadastro(codigoPontoTuristico: string = ""){
		this.router.navigate(['cadastros', codigoPontoTuristico], { relativeTo: this.activatedRoute })
	}

  carregarColunas(): Array<PoTableColumn>{
		return [
      {
        property: 'autor',
				label: 'Autor',
			},
      {
        property: 'comentario',
        label: 'Comentário'
      },
			{
				property: 'dataCriacao',
				label: 'Data de Criação'
			},
		]
	}

  buscaPaises(){
		this.http.get('pais').subscribe({
			next: (resposta)=>{
        this.lPaises = resposta.map((item) => ({label: item.nome, value: item.id}));
			},
			error: (erro)=>{
				this.poNotification.error(erro)
			}
		})
	}
}

interface Comentario {
  id: string;
  autor: string;
  comentario: string;
  dataCriacao: string;
}
