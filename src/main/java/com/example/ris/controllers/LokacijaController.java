package com.example.ris.controllers;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Vozilo;
import com.example.ris.services.LokacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class LokacijaController {
    @Autowired
    private LokacijaService _LokacijaService;

    @GetMapping("/getlokacije")
    public List<Lokacija> getSveLokacije() {
        return _LokacijaService.getSveLokacije();
    }

    @GetMapping("/getlokacije/{idlokacije}")
    public Lokacija getLokacijaById(@ModelAttribute("idlokacije") Integer idlokacije){
        return  _LokacijaService.getLokacijaByID(idlokacije);
    }

    @PostMapping("/dodajlokaciju")
    public String addNewLokacija(@ModelAttribute("lokacija") Lokacija lokacija, RedirectAttributes message) {
        _LokacijaService.dodajNovuLokaciju(lokacija);
        message.addFlashAttribute("message", "Lokacija uspješno dodana.");
        return "redirect:/adminpanel";
    }

    @PostMapping("/editlokacija")
    public String editLokacija(@ModelAttribute("lokacijaforedit") Lokacija lokacija, RedirectAttributes message) {
        _LokacijaService.editLokaciju(lokacija);
        message.addFlashAttribute("message", "Lokacija uspješno uređena.");
        return "redirect:/adminpanel";
    }

    @PostMapping("/deletelokacija/{idlokacije}")
    public String deleteLokacija(@ModelAttribute("lokacijafordelete") Integer idlokacije, RedirectAttributes message){
        _LokacijaService.deleteLocation(idlokacije);
        message.addFlashAttribute("message", "Lokacija uspješno uklonjena!");
        return "redirect:/adminpanel";
    }
}
