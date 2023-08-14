package com.visher.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/player")
public class AthleteController {

	//method to handle /showPlayerForm
	@RequestMapping("/showPlayerForm")
	public String showForm(Model model) {
		model.addAttribute("athlete", new Athlete());
		return "add-player-form";
	}

	//method to handle /processPlayerForm
	@RequestMapping("/processPlayerForm")
	public static String processForm(@ModelAttribute("athlete") Athlete myAthlete){
		return "player-confirmation";
	}

//	@RequestMapping("/processPlayerForm")
//	public static String processForm(@Valid @ModelAttribute("athlete") Athlete myAthlete, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "add-player-form";
//		}
//		return "player-confirmation";
//	}
}