package labes.facomp.ufpa.br.api_enderecos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import labes.facomp.ufpa.br.api_enderecos.model.CidadeModel;
import labes.facomp.ufpa.br.api_enderecos.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CidadeService {

    private final CidadeRepository cidadeRepository;

    public Page<CidadeModel> findByEstadoNome(String estado, int page, int size, Direction direction) {
        return cidadeRepository.findByEstadoNomeContainsIgnoreCase(estado,
                PageRequest.of(page, size, Sort.by(direction, "nome")));
    }

    public Page<CidadeModel> findByEstadoId(Integer estadoId, int page, int size, Direction direction) {
        return cidadeRepository.findByEstadoId(estadoId,
                PageRequest.of(page, size, Sort.by(direction, "nome")));
    }

}
