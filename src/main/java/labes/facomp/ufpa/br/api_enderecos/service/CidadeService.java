package labes.facomp.ufpa.br.api_enderecos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import labes.facomp.ufpa.br.api_enderecos.model.CidadeModel;
import labes.facomp.ufpa.br.api_enderecos.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public List<CidadeModel> findByEstadoNome(String estado) {
        return cidadeRepository.findByEstadoNomeContainsIgnoreCase(estado);
    }

    public List<CidadeModel> findByEstadoId(Integer estadoId) {
        return cidadeRepository.findByEstadoId(estadoId);
    }

}
