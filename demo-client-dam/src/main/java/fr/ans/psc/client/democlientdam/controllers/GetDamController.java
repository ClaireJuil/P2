package fr.ans.psc.client.democlientdam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class GetDamController {

	@GetMapping("/api")
	public String getDamModel(Model model) {

		// TODO recup du token d'API et affichage
		// appel à l'API avec le jeton d'API
		return "display-dam";
	}
}
