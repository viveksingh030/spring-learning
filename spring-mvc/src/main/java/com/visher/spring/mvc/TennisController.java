package com.visher.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TennisController {
    private final PlayerService service;

    public TennisController(PlayerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/")
    public String welcome() {
        return "main-menu";
    }

    @RequestMapping("/processPlayerForm")
    public String processForm(@RequestParam(value = "playerName", defaultValue = "Djokovic") String pName, Model model) {
        Player playerByName = service.getPlayerByName(pName);
        if (playerByName != null) {
            model.addAttribute("name", pName);
            model.addAttribute("id", playerByName.getId());
            model.addAttribute("nationality", playerByName.getNationality());
            model.addAttribute("titles", playerByName.getTitles());
            model.addAttribute("birthDate", playerByName.getBirthDate());
        }
        return "player-detail";
    }

    @RequestMapping(value = "/showPlayerForm")
    public String searchPlayerForm() {
        return "search-player-form";
    }
}