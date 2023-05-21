package labes.facomp.ufpa.br.api_enderecos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaisDTO {

	private Integer id;

	private String nome;

}
