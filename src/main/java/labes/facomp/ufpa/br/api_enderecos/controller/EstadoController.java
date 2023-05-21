package labes.facomp.ufpa.br.api_enderecos.controller;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
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
    public Page<EstadoDTO> findByPaisId(@RequestParam(required = false, defaultValue = "1") Integer id,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return estadoService.findByPaisId(id, page, size, direction).map(e -> mapper.map(e, EstadoDTO.class));
    }

    @GetMapping(params = "nome")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<EstadoDTO> findByPaisNome(@RequestParam(required = false, defaultValue = "") String nome,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return estadoService.findByPaisNome(nome, page, size, direction).map(e -> mapper.map(e, EstadoDTO.class));
    }

}
