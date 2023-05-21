package labes.facomp.ufpa.br.api_enderecos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import labes.facomp.ufpa.br.api_enderecos.model.PaisModel;
import labes.facomp.ufpa.br.api_enderecos.repository.PaisRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaisService {

    private final PaisRepository paisRepository;

    public List<PaisModel> findAll() {
        return paisRepository.findAll();
    }

    public List<PaisModel> findByNome(String nome) {
        return paisRepository.findByNomeContainsIgnoreCase(nome);
    }

}
