package labes.facomp.ufpa.br.api_enderecos.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Entity(name = "estado")
public class EstadoModel implements java.io.Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable = false)
	private PaisModel pais;

	@Column(name = "name", nullable = false)
	private String nome;

	@Column(name = "country_code", nullable = false, length = 2)
	private String codigoPais;

	@Column(name = "fips_code")
	private String codigoFips;

	@Column(name = "iso2")
	private String iso2;

	@Column(name = "type", length = 191)
	private String tipo;

	@Column(name = "latitude", precision = 10, scale = 8)
	private BigDecimal latitude;

	@Column(name = "longitude", precision = 11, scale = 8)
	private BigDecimal longitude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 35)
	private Date criadoEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", length = 35)
	private Date atualizadoEm;

	@Column(name = "flag", nullable = false)
	private boolean flag;

	@Column(name = "wikidataid")
	private String wikidataid;

	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	private Set<CidadeModel> cidades = new HashSet<>(0);

}
