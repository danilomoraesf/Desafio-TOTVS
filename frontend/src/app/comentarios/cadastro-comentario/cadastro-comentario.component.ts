import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService } from '@po-ui/ng-components';
import { HttpService } from 'src/app/service/http-service.service';

@Component({
  selector: 'app-cadastro-comentario',
  templateUrl: './cadastro-comentario.component.html',
  styleUrls: ['./cadastro-comentario.component.css']
})
export class CadastroComentarioComponent implements OnInit {
	idPontoTuristico: string;
	idComentario: string;
	formComentario: FormGroup;
	lPaises: FormGroup;
	title: string = "Novo cadastro de Comentário"
	constructor(private formBuilder: FormBuilder,
		private poNotification: PoNotificationService,
		private route: ActivatedRoute,
		private router: Router,
		private http: HttpService
		) { 

		this.formComentario = this.formBuilder.group({
			autor: ['', Validators.compose([Validators.required])],
			comentario: ['', Validators.compose([Validators.required])],
		})
	}

	ngOnInit(): void {
		this.idPontoTuristico = this.route.snapshot.paramMap.get('idPontoTuristico');
		this.idComentario = this.route.snapshot.paramMap.get('idComentario');
		if (this.idComentario){
			this.buscaDadosComentario()
			this.title = "Alteração do Comentário"
		}
	}

	salvar(){
		if (this.validarRegistro()){
			if (!this.idComentario){
				this.enviarPost()
			} else {
				this.enviarPut()
			}
		} else {
			this.poNotification.error("Preencha todos os campos antes de salvar as alterações!")
		}
	}

	voltar(){
		this.router.navigateByUrl("ponto-turistico/cadastro/" + this.idPontoTuristico)
	}

	validarRegistro(): boolean{
		return this.formComentario.valid;
	}

	enviarPost(){
		this.http.post('comentario',{...this.formComentario.value, pontoTuristicoId: this.idPontoTuristico}).subscribe({
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
		this.http.put('comentario/' + this.idComentario, {...this.formComentario.value, pontoTuristicoId: this.idPontoTuristico}).subscribe({
			next:(resposta) => {
				this.poNotification.success("Registro atualizado com sucesso!");
				this.voltar();
			},
			error:(erro) => {
				this.poNotification.error(erro)
			},
		})
	}

	buscaDadosComentario(){
		this.http.get('comentario/' + this.idComentario).subscribe({
			next: (resposta)=>{
        this.idPontoTuristico = resposta.pontoTuristicoId;
				this.formComentario.patchValue({
					autor: resposta.autor,
					comentario: resposta.comentario,
				})
			},
			error: (erro)=>{
				this.poNotification.error(erro)
			}
		})
	}

  

}
