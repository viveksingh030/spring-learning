package com.visher.spring.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/player")
public class AthleteController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}

	//method to handle /showPlayerForm
	@RequestMapping("/showPlayerForm")
	public String showForm(Model model) {
		model.addAttribute("athlete", new Athlete());
		return "add-player-form";
	}

	@RequestMapping("/processPlayerForm")
	public static String processForm(@Valid @ModelAttribute("athlete") Athlete myAthlete, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-player-form";
		}
		System.out.println(myAthlete);
		return "player-confirmation";
	}
}