package labes.facomp.ufpa.br.api_enderecos.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import labes.facomp.ufpa.br.api_enderecos.dto.EstadoDTO;
import labes.facomp.ufpa.br.api_enderecos.service.EstadoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/estado")
public class EstadoController {

    private final EstadoService estadoService;

    private final ModelMapper mapper;

    @GetMapping(params = "id")
    @ResponseStatus(code = HttpStatus.OK)
    public List<EstadoDTO> findByPaisId(@RequestParam(required = false, defaultValue = "1") Integer id) {
        return mapper.map(estadoService.findByPaisId(id), new TypeToken<List<EstadoDTO>>() {
        }.getType());
    }

    @GetMapping(params = "nome")
    @ResponseStatus(code = HttpStatus.OK)
    public List<EstadoDTO> findByPaisNome(@RequestParam(required = false, defaultValue = "") String nome) {
        return mapper.map(estadoService.findByPaisNome(nome), new TypeToken<List<EstadoDTO>>() {
        }.getType());
    }

}
