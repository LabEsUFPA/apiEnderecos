package labes.facomp.ufpa.br.api_enderecos.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDTO {

	private Integer id;

	private String nome;

	private BigDecimal latitude;

	private BigDecimal longitude;

}
