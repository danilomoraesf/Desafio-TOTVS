package br.com.juridico.totvs.fullstack.Backend.controller;

import br.com.juridico.totvs.fullstack.Backend.service.PontoTuristicoService;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController()
@RequestMapping("/pontoTuristico")
public class PontoTuristicoController {
    private final PontoTuristicoService pontoTuristicoService;

    public PontoTuristicoController(PontoTuristicoService pontoTuristicoService){
        this.pontoTuristicoService = pontoTuristicoService;
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public PontoTuristicoDTO create(@RequestBody PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDto){
        return this.pontoTuristicoService.create(pontoTuristicoCreateUpdateDto);
    }

    @GetMapping
    public List<PontoTuristicoDTO> getAll(){
        return this.pontoTuristicoService.getAllPontoTuristico();
    }

    @GetMapping("{paisId}/pais")
    public List<PontoTuristicoDTO> getPontoTuristicoByPais(@PathVariable Long paisId){
        return this.pontoTuristicoService.getPontoTuristicoByPais(paisId);
    }

    @GetMapping("{idPontoTuristico}")
    public PontoTuristicoDTO getPontoTuristicoById(@PathVariable Long idPontoTuristico){
        return this.pontoTuristicoService.getPontoTuristicobyId(idPontoTuristico);
    }

    @DeleteMapping("{idPontoTuristico}")
    @ResponseStatus( HttpStatus.NO_CONTENT )
    public void delete(@PathVariable Long idPontoTuristico){
        this.pontoTuristicoService.delete(idPontoTuristico);
    }

    @PutMapping("{idPontoTuristico}")
    public PontoTuristicoDTO update(@PathVariable Long idPontoTuristico,
                          @RequestBody PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDto ){
        return this.pontoTuristicoService.update(idPontoTuristico, pontoTuristicoCreateUpdateDto);
    }
}
