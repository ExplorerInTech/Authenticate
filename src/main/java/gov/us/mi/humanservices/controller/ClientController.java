package gov.us.mi.humanservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;
import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;


@Controller
@RequestMapping("/campaign")
public class ClientController {
	
	@GetMapping("/")
    public String index(){
        return "index";
    }
	
	@GetMapping("/_codexch")
	public String get(Model model,
            @AuthenticationPrincipal OidcUser oidcUser) {
		model.addAttribute("userName", oidcUser.getName());
        model.addAttribute("audience", oidcUser.getAudience());
        return "user";
	}
	
}
