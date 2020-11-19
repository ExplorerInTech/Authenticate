package gov.us.mi.humanservices.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class ResidentOutreachController {
	
	private final WebClient client;
	
	public ResidentOutreachController(WebClient client) {
		this.client = client;
	}
	
	@GetMapping("/")
    public String getProfile(Model model, @AuthenticationPrincipal OidcUser principal) {
		
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        
        return "index";
    }
	
	
	
	
	
	
	
}
