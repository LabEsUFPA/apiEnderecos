package labes.facomp.ufpa.br.api_enderecos.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import labes.facomp.ufpa.br.api_enderecos.model.PaisModel;
import labes.facomp.ufpa.br.api_enderecos.repository.PaisRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaisService {

    private final PaisRepository paisRepository;

    public Page<PaisModel> findAll(int page, int size, Direction direction) {
        return paisRepository.findAll(PageRequest.of(page, size, Sort.by(direction, "nome")));
    }

    public Page<PaisModel> findByNome(String nome, int page, int size, Direction direction) {
        return paisRepository.findByNomeContainsIgnoreCase(nome,
                PageRequest.of(page, size, Sort.by(direction, "nome")));
    }

}
