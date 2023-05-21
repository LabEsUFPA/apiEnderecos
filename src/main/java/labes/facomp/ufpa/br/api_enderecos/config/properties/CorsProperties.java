package labes.facomp.ufpa.br.api_enderecos.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cors")

public class CorsProperties {
	private String[] allowedOriginPatterns;

	public String[] getAllowedOriginPatterns() {
		return allowedOriginPatterns;
	}

	public void setAllowedOriginPatterns(String[] allowedOriginPatterns) {
		this.allowedOriginPatterns = allowedOriginPatterns;
	}
}
