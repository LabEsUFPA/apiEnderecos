package labes.facomp.ufpa.br.api_enderecos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import labes.facomp.ufpa.br.api_enderecos.model.EstadoModel;
import labes.facomp.ufpa.br.api_enderecos.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public Page<EstadoModel> findByPaisNome(String pais, int page, int size, Direction direction) {
        return estadoRepository.findByPaisNomeContainsIgnoreCase(pais,
                PageRequest.of(page, size, Sort.by(direction, "nome")));
    }

    public Page<EstadoModel> findByPaisId(Integer paisId, int page, int size, Direction direction) {
        return estadoRepository.findByPaisId(paisId,
                PageRequest.of(page, size, Sort.by(direction, "nome")));
    }

}
