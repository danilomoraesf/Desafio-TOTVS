package br.com.juridico.totvs.fullstack.Backend.service.dto;

public class PontoTuristicoCreateUpdateDTO {
    private String nome;
    private String cidade;
    private String melhorEstacao;
    private long paisId;

    public PontoTuristicoCreateUpdateDTO(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMelhorEstacao() {
        return melhorEstacao;
    }

    public void setMelhorEstacao(String melhorEstacao) {
        this.melhorEstacao = melhorEstacao;
    }

    public long getPaisId() {
        return paisId;
    }

    public void setPaisId(long paisId) {
        this.paisId = paisId;
    }
}
