package labes.facomp.ufpa.br.api_enderecos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import labes.facomp.ufpa.br.api_enderecos.model.EstadoModel;

public interface EstadoRepository extends CrudRepository<EstadoModel, Integer> {

    Page<EstadoModel> findByPaisNomeContainsIgnoreCase(String pais, Pageable pageable);

    Page<EstadoModel> findByPaisId(Integer paisId, Pageable pageable);

    Page<EstadoModel> findByNomeContainsIgnoreCaseAndPaisId(String nome, Integer paisId, Pageable pageable);

}
