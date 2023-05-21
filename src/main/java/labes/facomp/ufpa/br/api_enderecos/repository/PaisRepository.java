package labes.facomp.ufpa.br.api_enderecos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import labes.facomp.ufpa.br.api_enderecos.model.PaisModel;

public interface PaisRepository extends CrudRepository<PaisModel, Integer> {

    List<PaisModel> findAll();

    List<PaisModel> findByNomeContainsIgnoreCase(String nome);

}
