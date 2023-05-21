package labes.facomp.ufpa.br.api_enderecos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import labes.facomp.ufpa.br.api_enderecos.model.CidadeModel;

public interface CidadeRepository extends CrudRepository<CidadeModel, Integer> {

    List<CidadeModel> findByEstadoNomeContainsIgnoreCase(String estado);

    List<CidadeModel> findByEstadoId(Integer estadoId);

}
