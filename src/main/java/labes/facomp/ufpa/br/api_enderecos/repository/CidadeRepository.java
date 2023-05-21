package labes.facomp.ufpa.br.api_enderecos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import labes.facomp.ufpa.br.api_enderecos.model.CidadeModel;

public interface CidadeRepository extends CrudRepository<CidadeModel, Integer> {

    Page<CidadeModel> findByEstadoNomeContainsIgnoreCase(String estado, Pageable pageable);

    Page<CidadeModel> findByEstadoId(Integer estadoId, Pageable pageable);

}
