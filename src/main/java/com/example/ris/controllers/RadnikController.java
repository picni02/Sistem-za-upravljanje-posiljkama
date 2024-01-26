package com.example.ris.controllers;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Radnik;
import com.example.ris.services.RadnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RadnikController {
    @Autowired
    private RadnikService _RadnikService;

    @GetMapping("/getradnici")
    public List<Radnik> getSviRadnici() {
        return _RadnikService.getSviRadnici();
    }

    @GetMapping("/getradnici/{idradnika}")
    public Radnik getRadnikById(@ModelAttribute("idradnika") Integer idRadnika){
        return  _RadnikService.getRadnikById(idRadnika);
    }

    @PostMapping("/dodajradnika")
    public String addNewRadnik(@ModelAttribute("radnik") Radnik radnik, RedirectAttributes message) {
        _RadnikService.registerRadnik(radnik);
        message.addFlashAttribute("message", "Radnik uspješno dodan.");
        return "redirect:adminpanel";
    }

    @PostMapping("/editradnik")
    public String editRadnika(@ModelAttribute("radnikforedit") Radnik radnik, RedirectAttributes message) {
        _RadnikService.editRadnik(radnik);
        message.addFlashAttribute("message", "Radnik uspješno uređen.");
        return "redirect:/adminpanel";
    }

    @PostMapping("/deleteradnik/{idradnika}")
    public String deleteRadnik(@ModelAttribute("radnikfordelete") Integer idradnika, RedirectAttributes message){
        _RadnikService.deleteRadnik(idradnika);
        message.addFlashAttribute("message", "Radnik uspješno uklonjen!");
        return "redirect:/adminpanel";
    }
}
