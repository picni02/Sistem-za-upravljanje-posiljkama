package com.example.ris.controllers;

import com.example.ris.models.entities.Vozilo;
import com.example.ris.services.VoziloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VoziloController {
    @Autowired
    private VoziloService _VoziloService;

    @GetMapping("/getvozila")
    public List<Vozilo> getSvaVozila() {
        return _VoziloService.getSvaVozila();
    }


    @PostMapping("/dodajvozilo")
    public String addNewVozilo(@ModelAttribute("vozilo") Vozilo vozilo, RedirectAttributes message) {
        _VoziloService.dodajNovoVozilo(vozilo);
        message.addFlashAttribute("message", "Vozilo uspješno dodano.");
        return "redirect:/adminpanel";
    }

    @PostMapping("/editvozilo")
    public String editVozilo(@ModelAttribute("voziloforedit") Vozilo vozilo, RedirectAttributes message) {
        _VoziloService.editVozilo(vozilo);
        message.addFlashAttribute("message", "Vozilo uspješno uređeno.");
        return "redirect:/adminpanel";
    }

    @PostMapping("/deletevozilo/{idvozila}")
    public String deleteVozilo(@RequestParam("vozilofordelete") Integer idvozila, RedirectAttributes message){
        _VoziloService.deleteVozilo(idvozila);
        message.addFlashAttribute("message", "Vozilo uspješno uklonjeno!");
        return "redirect:/adminpanel";
    }
}
