package no.haakon.begynnelse;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class WebControlleur {
	public static final String standardOppskriftUuid = "e0f5c137-d4a5-42be-80e9-03015b973ce7";
	
	private final OppskriftDao oppskriftDao = new OppskriftDao();
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="Navn") String name, Model model) {
		return "greeting";
	}
	
	@RequestMapping("/oppskrift")
	public String oppskrift (@RequestParam(value="uuid", required=false, defaultValue=standardOppskriftUuid) String oppskriftUuid, Model model) {
		Optional<Oppskrift> recipe = oppskriftDao.loadWithUuid(oppskriftUuid);
		model.addAttribute("recipe", recipe.orElse(EmptyOppskrift.empty));
		return "oppskrift";
	}
}
