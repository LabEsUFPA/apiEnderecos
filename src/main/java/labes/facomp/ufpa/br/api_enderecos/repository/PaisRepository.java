package labes.facomp.ufpa.br.api_enderecos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import labes.facomp.ufpa.br.api_enderecos.model.PaisModel;

public interface PaisRepository extends CrudRepository<PaisModel, Integer> {

    Page<PaisModel> findAll(Pageable pageable);

    Page<PaisModel> findByNomeContainsIgnoreCase(String nome, Pageable pageable);

}
