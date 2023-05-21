package labes.facomp.ufpa.br.api_enderecos.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import labes.facomp.ufpa.br.api_enderecos.config.properties.CorsProperties;
import labes.facomp.ufpa.br.api_enderecos.config.properties.RsaKeyProperties;
import labes.facomp.ufpa.br.api_enderecos.config.properties.TokenProperties;
import lombok.RequiredArgsConstructor;

/**
 * Responsável pelas configurações gerais da aplicação.
 *
 * @author Alfredo Gabriel
 * @since 26/03/2023
 * @version 1.0
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(value = { RsaKeyProperties.class, TokenProperties.class, CorsProperties.class })
public class ApplicationConfig {

	// private final UsuarioService usuarioService;

	// @Bean
	// public UserDetailsService userDetailsService() {
	// return usuarioService;
	// }

	// @Bean
	// public AuthenticationManager authenticationManager() {
	// DaoAuthenticationProvider authenticationProvider = new
	// DaoAuthenticationProvider();
	// authenticationProvider.setUserDetailsService(userDetailsService());
	// return new ProviderManager(authenticationProvider);
	// }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
