package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.Comentario;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    List<Comentario> listComentario = null;

    ComentarioServiceImpl(){
        this.listComentario = new ArrayList<>();
        this.listComentario.add(new Comentario(1L,
                "Danilo",
                "Maravilhoso",
                LocalDateTime.now(),
                1L));
    }

    @Override
    public ComentarioDTO create(ComentarioCreateUpdateDTO comentarioCreateUpdateDto) {
        Comentario novoComentario = new Comentario(
                this.getNewId(),
                comentarioCreateUpdateDto.getAutor(),
                comentarioCreateUpdateDto.getComentario(),
                LocalDateTime.now(),
                comentarioCreateUpdateDto.getPontoTuristicoId());

        this.listComentario.add(novoComentario);

        return new ComentarioDTO(novoComentario);
    }

    @Override
    public ComentarioDTO update(Long id, ComentarioCreateUpdateDTO comentarioCreateUpdateDto) {
        Comentario comentario = this.getComentarioById(id);
        int index = this.listComentario.indexOf(comentario);
        if (comentario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        comentario.setAutor(comentarioCreateUpdateDto.getAutor());
        comentario.setComentario(comentarioCreateUpdateDto.getComentario());
        comentario.setPontoTuristicoId(comentarioCreateUpdateDto.getPontoTuristicoId());

        this.listComentario.set(index, comentario);
        return new ComentarioDTO(comentario);
    }

    @Override
    public void delete(Long id) {
        Comentario comentario = this.getComentarioById(id);
        this.listComentario.remove(comentario);
    }

    @Override
    public ComentarioDTO getComentariobyId(Long id) {
        Comentario comentario = this.getComentarioById(id);
        if (comentario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ComentarioDTO(comentario);
    }

    @Override
    public List<ComentarioDTO> getComentarioByPontoTuristico(Long pontoTuristicoId) {
        return this.listComentario.stream()
                .filter(x -> x.getPontoTuristicoId().equals(pontoTuristicoId))
                .map(pontoTuristico -> new ComentarioDTO(pontoTuristico))
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> getAllComentario() {
        return this.listComentario.stream()
                .map(comentario -> new ComentarioDTO(comentario))
                .collect(Collectors.toList());
    }

    private Long getNewId(){
        if (this.listComentario.size() > 0){
            return this.listComentario.stream().max(Comparator
                            .comparingDouble(Comentario::getId))
                    .get()
                    .getId()+1;
        } else {
            return Long.valueOf(1);
        }
    }

    private Comentario getComentarioById(Long id){
        return this.listComentario.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst()
                .orElse(null);
    }

}
