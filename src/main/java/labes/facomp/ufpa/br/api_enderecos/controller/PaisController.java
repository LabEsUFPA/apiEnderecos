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

/**
 * Responsável por fornecer um end-point para criar um novo anuncio.
 *
 * @author Alfredo Gabriel
 * @since 21/04/2023
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pais")
public class PaisController {

    private final PaisService paisService;

    private final ModelMapper mapper;

    /**
     *
     * @param page
     * @param size
     * @param direction
     * @param internacionalizacao
     * @return
     */
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Page<PaisDTO> findAll(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction,
            @RequestParam(defaultValue = "pt-BR", required = false) String internacionalizacao) {
        return paisService.findAll(page, size, direction, internacionalizacao).map(e -> mapper.map(e, PaisDTO.class));
    }

    /**
     *
     * @param nome
     * @param page
     * @param size
     * @param direction
     * @param internacionalizacao
     * @return
     */
    @GetMapping(params = { "nome" })
    @ResponseStatus(code = HttpStatus.OK)
    public Page<PaisDTO> findByNome(
            @RequestParam(required = false, defaultValue = "") String nome,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction,
            @RequestParam(defaultValue = "pt-BR", required = false) String internacionalizacao) {

        return paisService.findByNome(nome, page, size, direction,
                internacionalizacao).map(e -> mapper.map(e, PaisDTO.class));

    }

}
