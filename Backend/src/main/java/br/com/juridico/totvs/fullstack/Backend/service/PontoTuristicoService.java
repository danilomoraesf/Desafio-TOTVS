package br.com.juridico.totvs.fullstack.Backend.service;

import br.com.juridico.totvs.fullstack.Backend.domain.PontoTuristico;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoCreateUpdateDTO;
import br.com.juridico.totvs.fullstack.Backend.service.dto.PontoTuristicoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PontoTuristicoService {
    List<PontoTuristico> listPontoTuristico = null;
    public PontoTuristicoDTO create(PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO);
    public PontoTuristicoDTO update(Long id, PontoTuristicoCreateUpdateDTO pontoTuristicoCreateUpdateDTO);
    public void delete(Long id);
    public PontoTuristicoDTO getPontoTuristicobyId(Long id);
    public List<PontoTuristicoDTO> getPontoTuristicoByPais(Long paisId);
    public List<PontoTuristicoDTO> getAllPontoTuristico();
}
