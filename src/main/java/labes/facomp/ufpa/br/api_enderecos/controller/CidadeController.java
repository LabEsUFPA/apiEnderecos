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

import labes.facomp.ufpa.br.api_enderecos.dto.CidadeDTO;
import labes.facomp.ufpa.br.api_enderecos.service.CidadeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cidade")
public class CidadeController {

    private final CidadeService cidadeService;

    private final ModelMapper mapper;

    @GetMapping(params = "id")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CidadeDTO> findByEstado(@RequestParam(required = false, defaultValue = "1") Integer id,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return cidadeService.findByEstadoId(id, page, size, direction).map(e -> mapper.map(e, CidadeDTO.class));
    }

    @GetMapping(params = "nome")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CidadeDTO> findByEstado(@RequestParam(required = false, defaultValue = "") String nome,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return cidadeService.findByEstadoNome(nome, page, size, direction).map(e -> mapper.map(e, CidadeDTO.class));
    }
    
}
