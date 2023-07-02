package labes.facomp.ufpa.br.api_enderecos.controller;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import labes.facomp.ufpa.br.api_enderecos.dto.EstadoDTO;
import labes.facomp.ufpa.br.api_enderecos.service.EstadoService;
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
@RequestMapping(value = "/estado")
public class EstadoController {

    private final EstadoService estadoService;

    private final ModelMapper mapper;

    /**
     *
     * @param page
     * @param size
     * @param paisId
     * @param direction
     * @return
     */
    @GetMapping(params = "paisId")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<EstadoDTO> findByPaisId(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "31", required = false) Integer paisId,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return estadoService.findByPaisId(paisId, page, size, direction).map(e -> mapper.map(e, EstadoDTO.class));
    }

    /**
     *
     * @param nome
     * @param page
     * @param size
     * @param direction
     * @return
     */
    @GetMapping(params = "nomePais")
    @ResponseStatus(code = HttpStatus.OK)
    public Page<EstadoDTO> findByPaisNome(
            @RequestParam(required = false, defaultValue = "") String nomePais,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return estadoService.findByPaisNome(nomePais, page, size, direction).map(e -> mapper.map(e, EstadoDTO.class));
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public EstadoDTO findById(@PathVariable Integer id) {
        return mapper.map(estadoService.findById(id), EstadoDTO.class);
    }

    /**
     *
     * @param page
     * @param size
     * @param paisId
     * @param nomeEstado
     * @param direction
     * @return
     */
    @GetMapping(params = { "nomeEstado", "paisId" })
    @ResponseStatus(code = HttpStatus.OK)
    public Page<EstadoDTO> findByNomeAndEstadoId(
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "31", required = false) Integer paisId,
            @RequestParam(defaultValue = "", required = false) String nomeEstado,
            @RequestParam(defaultValue = "ASC", required = false) Direction direction) {
        return estadoService.findByNomeAndPaisId(nomeEstado, paisId, page, size, direction)
                .map(e -> mapper.map(e, EstadoDTO.class));
    }

}
