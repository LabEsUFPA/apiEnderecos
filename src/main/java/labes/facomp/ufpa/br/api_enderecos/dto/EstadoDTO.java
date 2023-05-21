package labes.facomp.ufpa.br.api_enderecos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO implements java.io.Serializable {

	private Integer id;

	private String nome;

}
