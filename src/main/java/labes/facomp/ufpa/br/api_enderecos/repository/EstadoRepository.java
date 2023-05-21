package labes.facomp.ufpa.br.api_enderecos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import labes.facomp.ufpa.br.api_enderecos.model.EstadoModel;

public interface EstadoRepository extends CrudRepository<EstadoModel, Integer> {

    List<EstadoModel> findByPaisNomeContainsIgnoreCase(String pais);

    List<EstadoModel> findByPaisId(Integer paisId);
    
}
