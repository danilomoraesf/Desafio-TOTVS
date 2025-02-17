package br.com.juridico.totvs.fullstack.Backend.service.dto;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;

import java.util.ArrayList;
import java.util.List;

public class PontoTuristicoDTO {
    private Long id;
    private String nome;
    private String melhorEstacao;
    private String cidade;
    private Long paisId;
    private List<ComentarioDTO> comentarios;

    public PontoTuristicoDTO(Long id, String nome, String melhorEstacao, String cidade, Long paisId, List<ComentarioDTO> comentarios){
        this.id = id;
        this.nome = nome;
        this.melhorEstacao = melhorEstacao;
        this.cidade = cidade;
        this.paisId = paisId;
        this.comentarios = comentarios;
    }

    public PontoTuristicoDTO(PontoTuristico pontoTuristico, List<ComentarioDTO> comentarios){
        this.id = pontoTuristico.getId();
        this.nome = pontoTuristico.getNome();
        this.cidade = pontoTuristico.getCidade();
        this.melhorEstacao = pontoTuristico.getMelhorEstacao();
        this.paisId = pontoTuristico.getPaisId();
        this.comentarios = comentarios != null ? comentarios : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMelhorEstacao() {
        return melhorEstacao;
    }

    public void setMelhorEstacao(String melhorEstacao) {
        this.melhorEstacao = melhorEstacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getPaisId() {
        return paisId;
    }

    public void setPaisId(long paisId) {
        this.paisId = paisId;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
