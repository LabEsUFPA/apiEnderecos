package labes.facomp.ufpa.br.api_enderecos.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
@Entity(name = "pais")
public class PaisModel {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", nullable = false, length = 100)
	private String nome;

	@Column(name = "iso3", length = 3)
	private String iso3;

	@Column(name = "numeric_code", length = 3)
	private String codigoNumerico;

	@Column(name = "iso2", length = 2)
	private String iso2;

	@Column(name = "phonecode")
	private String codicoTelefonico;

	@Column(name = "capital")
	private String capital;

	@Column(name = "currency")
	private String currency;

	@Column(name = "currency_name")
	private String currencyName;

	@Column(name = "currency_symbol")
	private String currencySymbol;

	@Column(name = "tld")
	private String tld;

	@Column(name = "native")
	private String nativo;

	@Column(name = "region")
	private String regiao;

	@Column(name = "subregion")
	private String subregiao;

	@Column(name = "timezones")
	private String timezones;

	@Column(name = "translations")
	private String traducoes;

	@Column(name = "latitude", precision = 10, scale = 8)
	private BigDecimal latitude;

	@Column(name = "longitude", precision = 11, scale = 8)
	private BigDecimal longitude;

	@Column(name = "emoji", length = 191)
	private String emoji;

	@Column(name = "emojiu", length = 191)
	private String emojiu;

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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
	private Set<EstadoModel> estados = new HashSet<>(0);

	@Builder.Default
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
	private Set<CidadeModel> cidades = new HashSet<>(0);

}
