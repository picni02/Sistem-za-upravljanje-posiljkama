package com.example.ris.controllers;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Okrug;
import com.example.ris.services.OkrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OkrugController {

    @Autowired
    private OkrugService _OkrugService;

    @GetMapping("/getokruzi")
    public List<Okrug> getSviOkruzi() {
        return _OkrugService.getSviOkruzi();
    }

    @GetMapping("/getokruzi/{idokruga}")
    public Okrug getOkrugById(@ModelAttribute("idokruga") Integer idokruga){
        return _OkrugService.getOkrugByID(idokruga);
    }

    @PostMapping("/dodajokrug")
    public String addNewOkrug(@ModelAttribute("okrug") Okrug okrug, RedirectAttributes message) {
        _OkrugService.dodajNoviOkrug(okrug);
        message.addFlashAttribute("message", "Okrug uspješno dodan.");
        return "redirect:/adminpanel";
    }

    @PostMapping("/editokrug")
    public String editOkrug(@ModelAttribute("okrugforedit") Okrug okrug, RedirectAttributes message) {
        _OkrugService.editOkrug(okrug);
        message.addFlashAttribute("message", "Okrug uspješno uređen.");
        return "redirect:/adminpanel";
    }

    @PostMapping("/deleteokrug/{idokruga}")
    public String deleteOkrug(@ModelAttribute("okrugfordelete") Integer idokruga, RedirectAttributes message){
        _OkrugService.deleteOkrug(idokruga);
        message.addFlashAttribute("message", "Okrug uspješno uklonjen!");
        return "redirect:/adminpanel";
    }
}
