package fr.ans.psc.client.democlientdam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {


	@GetMapping("/test")
	public String getApiToken(Model model){
		
	
		return "test";
	}
}
