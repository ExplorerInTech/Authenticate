package gov.us.mi.humanservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {
	
	@Bean
	WebClient client(ClientRegistrationRepository regRepo,
					 OAuth2AuthorizedClientRepository cliRepo) {
		ServletOAuth2AuthorizedClientExchangeFilterFunction fFunc =
				new ServletOAuth2AuthorizedClientExchangeFilterFunction(
						regRepo,
						cliRepo
				);

		fFunc.setDefaultOAuth2AuthorizedClient(true);

		return WebClient.builder()
				.baseUrl("http://localhost:8081/campaigns")
				.apply(fFunc.oauth2Configuration())
				.build();
	}

}
