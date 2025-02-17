package br.com.juridico.totvs.fullstack.Backend.service.dto;

public class ComentarioCreateUpdateDTO {
    private String autor;
    private String comentario;
    private long pontoTuristicoId;

    public ComentarioCreateUpdateDTO(){

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

    public long getPontoTuristicoId() {
        return pontoTuristicoId;
    }

    public void setPontoTuristicoId(long pontoTuristicoId) {
        this.pontoTuristicoId = pontoTuristicoId;
    }
}
