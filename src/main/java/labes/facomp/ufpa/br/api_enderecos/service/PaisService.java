package labes.facomp.ufpa.br.api_enderecos.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import labes.facomp.ufpa.br.api_enderecos.model.PaisModel;
import labes.facomp.ufpa.br.api_enderecos.repository.PaisRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaisService {

    private final PaisRepository paisRepository;

    private final ObjectMapper objectMapper;

    public Page<PaisModel> findAll(int page, int size, Direction direction, String internacionalizacao) {
        Page<PaisModel> paises = paisRepository.findAll(PageRequest.of(page, size, Sort.by(direction, "nome")));
        paises.forEach(e -> {
            try {
                Map<String, String> traducao = objectMapper.readValue(e.getTraducoes(),
                        new TypeReference<Map<String, String>>() {
                        });
                e.setNome(traducao.get(internacionalizacao));
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
        });
        return paises;
    }

    public Page<PaisModel> findByNome(String nome, int page, int size, Direction direction,
            String internacionalizacao) {
        Page<PaisModel> paises = paisRepository.findByTraducoesContainsIgnoreCase(nome,
                PageRequest.of(page, size, Sort.by(direction, "nome")));
        paises.forEach(e -> {
            try {
                Map<String, String> traducao = objectMapper.readValue(e.getTraducoes(),
                        new TypeReference<Map<String, String>>() {
                        });
                e.setNome(traducao.get(internacionalizacao));
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            }
        });
        return paises;
    }

}
