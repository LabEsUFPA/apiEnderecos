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
    public List<PaisDTO> findAll() {
        return mapper.map(paisService.findAll(), new TypeToken<List<PaisDTO>>() {
        }.getType());
    }

    @GetMapping(params = "nome")
    @ResponseStatus(code = HttpStatus.OK)
    public List<PaisDTO> findByNome(@RequestParam(required = false, defaultValue = "") String nome) {
        return mapper.map(paisService.findByNome(nome), new TypeToken<List<PaisDTO>>() {
        }.getType());
    }

}
