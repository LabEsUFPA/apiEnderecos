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

import labes.facomp.ufpa.br.api_enderecos.dto.PaisDTO;
import labes.facomp.ufpa.br.api_enderecos.service.PaisService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pais")
public class PaisController {

    private final PaisService paisService;

    private final ModelMapper mapper;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<PaisDTO> findAll(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return paisService.findAll(page, size, direction).map(e -> mapper.map(e, PaisDTO.class));
    }

    @GetMapping(params = { "nome" })
    @ResponseStatus(code = HttpStatus.OK)
    public Page<PaisDTO> findByNome(@RequestParam(required = false, defaultValue = "") String nome,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {

        return paisService.findByNome(nome, page, size, direction).map(e -> mapper.map(e, PaisDTO.class));

    }

}
