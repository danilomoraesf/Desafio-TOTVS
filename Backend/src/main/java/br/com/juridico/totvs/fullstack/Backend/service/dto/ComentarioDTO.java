package br.com.juridico.totvs.fullstack.Backend.service.dto;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import java.time.LocalDateTime;

public class ComentarioDTO {
    private Long id;
    private String autor;
    private String comentario;
    private LocalDateTime dataCriacao;
    private Long pontoTuristicoId;

    public ComentarioDTO(Long id, String nome, String melhorEstacao, String cidade, Long paisId){
        this.id = id;
        this.autor = autor;
        this.comentario = comentario;
        this.dataCriacao = dataCriacao;
        this.pontoTuristicoId = pontoTuristicoId;
    }

    public ComentarioDTO(Comentario comentario){
        this.id = comentario.getId();
        this.autor = comentario.getAutor();
        this.comentario = comentario.getComentario();
        this.dataCriacao = comentario.getDataCriacao();
        this.pontoTuristicoId = comentario.getPontoTuristicoId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime  dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(long pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }
}
