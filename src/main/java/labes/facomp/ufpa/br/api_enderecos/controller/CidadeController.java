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
    public List<CidadeDTO> findByEstado(@RequestParam(required = false, defaultValue = "1") Integer id) {
        return mapper.map(cidadeService.findByEstadoId(id), new TypeToken<List<CidadeDTO>>() {
        }.getType());
    }

    @GetMapping(params = "nome")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CidadeDTO> findByEstado(@RequestParam(required = false, defaultValue = "") String nome) {
        return mapper.map(cidadeService.findByEstadoNome(nome), new TypeToken<List<CidadeDTO>>() {
        }.getType());
    }

}
