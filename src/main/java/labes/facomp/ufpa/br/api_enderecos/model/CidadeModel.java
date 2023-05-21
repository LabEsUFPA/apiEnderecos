package labes.facomp.ufpa.br.api_enderecos.model;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cidade")
public class CidadeModel {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id", nullable = false)
	private EstadoModel estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable = false)
	private PaisModel pais;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "state_code", nullable = false)
	private String stateCode;

	@Column(name = "country_code", nullable = false, length = 2)
	private String countryCode;

	@Column(name = "latitude", nullable = false, precision = 10, scale = 8)
	private BigDecimal latitude;

	@Column(name = "longitude", nullable = false, precision = 11, scale = 8)
	private BigDecimal longitude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, length = 35)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false, length = 35)
	private Date updatedAt;

	@Column(name = "flag", nullable = false)
	private boolean flag;

	@Column(name = "wikidataid")
	private String wikidataid;

}
