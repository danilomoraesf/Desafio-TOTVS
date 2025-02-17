package br.com.juridico.totvs.fullstack.Backend.domain;

import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Comentario {

    private Long id;
    private String autor;
    private String comentario;
    private LocalDateTime dataCriacao;
    private Long pontoTuristicoId;

    public Comentario(Long id, String autor, String comentario, LocalDateTime dataCriacao, Long pontoTuristicoId){
        this.id = id;
        this.autor = autor;
        this.comentario = comentario;
        this.dataCriacao = dataCriacao;
        this.pontoTuristicoId = pontoTuristicoId;
    }

    public Comentario(ComentarioDTO comentarioDTO){
        this.id = comentarioDTO.getId();
        this.autor = comentarioDTO.getAutor();
        this.comentario = comentarioDTO.getComentario();
        this.dataCriacao = comentarioDTO.getDataCriacao();
        this.pontoTuristicoId = comentarioDTO.getPontoTuristicoId();
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

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(long pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }
}
