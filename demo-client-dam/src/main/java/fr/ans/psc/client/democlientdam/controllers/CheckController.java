package fr.ans.psc.client.democlientdam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
	    @GetMapping("/insecure/check")
	    public String check() {
	        return "demo-client-dam webapp is alive";
	    }
	}
