package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.service.dto.ComentarioDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PontoTuristicoServiceImpl implements PontoTuristicoService {
    private final ComentarioService comentarioService;
    List<PontoTuristico> listPontoTuristico = null;

    @Autowired
    PontoTuristicoServiceImpl(ComentarioService comentarioService){
        this.comentarioService = comentarioService;
        this.listPontoTuristico = new ArrayList<>();
        this.listPontoTuristico.add(new PontoTuristico(1L,
                "Cristo Redentor",
                "Rio de Janeiro",
                "Verao",
                1L));
    }

    @Override
    public PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDto) {
        PontoTuristico novoPontoTuristico = new PontoTuristico(
                this.getNewId(),
                pontoTuristicoCreateUpdateDto.getNome(),
                pontoTuristicoCreateUpdateDto.getCidade(),
                pontoTuristicoCreateUpdateDto.getMelhorEstacao(),
                pontoTuristicoCreateUpdateDto.getPaisId());

        this.listPontoTuristico.add(novoPontoTuristico);

        return new PontoTuristicoDTO(novoPontoTuristico, null);
    }

    @Override
    public PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDto) {
        PontoTuristico pontoTuristico = this.getPontoTuristicoById(id);
        int index = this.listPontoTuristico.indexOf(pontoTuristico);
        if (pontoTuristico == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        pontoTuristico.setNome(pontoTuristicoCreateUpdateDto.getNome());
        pontoTuristico.setCidade(pontoTuristicoCreateUpdateDto.getCidade());
        pontoTuristico.setMelhorEstacao(pontoTuristicoCreateUpdateDto.getMelhorEstacao());
        pontoTuristico.setPaisId(pontoTuristicoCreateUpdateDto.getPaisId());

        this.listPontoTuristico.set(index, pontoTuristico);
        return new PontoTuristicoDTO(pontoTuristico, null);
    }

    @Override
    public void delete(Long id) {
        PontoTuristico pontoTuristico = this.getPontoTuristicoById(id);
        this.listPontoTuristico.remove(pontoTuristico);
    }

    @Override
    public PontoTuristicoDTO getPontoTuristicobyId(Long id) {
        PontoTuristico pontoTuristico = this.getPontoTuristicoById(id);
        if (pontoTuristico == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        List<ComentarioDTO> comentarios = comentarioService.getComentarioByPontoTuristico(id);

        return new PontoTuristicoDTO(pontoTuristico, comentarios);
    }

    @Override
    public List<PontoTuristicoDTO> getPontoTuristicoByPais(Long paisId) {

        return this.listPontoTuristico.stream()
                .filter(x -> x.getPaisId().equals(paisId))
                .map(pontoTuristico -> {
                    List<ComentarioDTO> comentarios = comentarioService.getComentarioByPontoTuristico(pontoTuristico.getId());
                    return new PontoTuristicoDTO(pontoTuristico, comentarios);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<PontoTuristicoDTO> getAllPontoTuristico() {
        ComentarioService comentarioService = new ComentarioServiceImpl();

        return this.listPontoTuristico.stream()
                .map(pontoTuristico -> {
                    List<ComentarioDTO> comentarios = comentarioService.getComentarioByPontoTuristico(pontoTuristico.getId());
                    return new PontoTuristicoDTO(pontoTuristico, comentarios);
                })
                .collect(Collectors.toList());
    }

    private Long getNewId(){
        if (this.listPontoTuristico.size() > 0){
            return this.listPontoTuristico.stream().max(Comparator
                            .comparingDouble(PontoTuristico::getId))
                    .get()
                    .getId()+1;
        } else {
            return Long.valueOf(1);
        }
    }

    private PontoTuristico getPontoTuristicoById(Long id){
        return this.listPontoTuristico.stream()
                .filter(x -> Objects.equals(x.getId(), id))
                .findFirst()
                .orElse(null);
    }

}
