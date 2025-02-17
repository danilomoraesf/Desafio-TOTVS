package br.com.juridico.totvs.fullstack.Backend.domain;

import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;

public class PontoTuristico {

    private Long id;
    private String nome;
    private String cidade;
    private String melhorEstacao;
    private Long paisId;

    public PontoTuristico(Long id, String nome, String cidade, String melhorEstacao, Long paisId){
        this.id = id;
        this.nome = nome;
        this.melhorEstacao = melhorEstacao;
        this.cidade = cidade;
        this.paisId = paisId;
    }

    public PontoTuristico(PontoTuristicoDTO pontoTuristicoDTO){
        this.id = pontoTuristicoDTO.getId();
        this.nome = pontoTuristicoDTO.getNome();
        this.melhorEstacao = pontoTuristicoDTO.getMelhorEstacao();
        this.cidade = pontoTuristicoDTO.getCidade();
        this.paisId = pontoTuristicoDTO.getPaisId();
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

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(long paisId) {
        this.paisId = paisId;
    }
}
