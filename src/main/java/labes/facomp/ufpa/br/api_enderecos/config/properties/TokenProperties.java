package labes.facomp.ufpa.br.api_enderecos.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "token")
public class TokenProperties {

	/**
	 * Tempo em horas para expirar o token
	 *
	 */
	private Integer expiresHours;

	public Integer getExpiresHours() {
		return expiresHours;
	}

	public void setExpiresHours(Integer expiresHours) {
		this.expiresHours = expiresHours;
	}
}
