package labes.facomp.ufpa.br.api_enderecos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import labes.facomp.ufpa.br.api_enderecos.model.EstadoModel;
import labes.facomp.ufpa.br.api_enderecos.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public List<EstadoModel> findByPaisNome(String pais) {
        return estadoRepository.findByPaisNomeContainsIgnoreCase(pais);
    }

    public List<EstadoModel> findByPaisId(Integer paisId) {
        return estadoRepository.findByPaisId(paisId);
    }

}
