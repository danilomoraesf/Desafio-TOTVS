package br.com.juridico.totvs.fullstack.Backend.service.dto;

import br.com.juridico.totvs.fullstack.Backend.domain.Pais;

import java.util.ArrayList;
import java.util.List;

public class PaisDTO {
    private Long id;
    private String nome;
    private String sigla;
    private String continente;
    private int ddi;
    private List<PontoTuristicoDTO> pontosTuristicos; // Adicionar lista de pontos turísticos

    public PaisDTO(Long id, String nome, String sigla, String continente, int ddi, List<PontoTuristicoDTO> pontosTuristicos){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.continente = continente;
        this.ddi = ddi;
        this.pontosTuristicos = pontosTuristicos;
    }

    public PaisDTO(Pais pais, List<PontoTuristicoDTO> pontosTuristicos){
        this.id = pais.getId();
        this.nome = pais.getNome();
        this.continente = pais.getContinente();
        this.sigla = pais.getSigla();
        this.ddi = pais.getDdi();
        this.pontosTuristicos = pontosTuristicos != null ? pontosTuristicos : new ArrayList<>();
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdd(int ddi) {
        this.ddi = ddi;
    }

    public List<PontoTuristicoDTO> getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void setPontosTuristicos(List<PontoTuristicoDTO> pontosTuristicos) {
          this.pontosTuristicos = pontosTuristicos;
    }
}
