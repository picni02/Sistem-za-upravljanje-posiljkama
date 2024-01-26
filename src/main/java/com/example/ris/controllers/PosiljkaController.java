package com.example.ris.controllers;

import com.example.ris.models.entities.Posiljka;
import com.example.ris.models.entities.Vozilo;
import com.example.ris.services.PosiljkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PosiljkaController {

    @Autowired
    private PosiljkaService _PosiljkaService;

    @GetMapping("/getposiljke")
    public String getSvePosiljke(@RequestParam(value = "idOkruga", required = false) String okrugid,@RequestParam(value = "status", required = false) String status, Model model) {
        if(okrugid != null) model.addAttribute("posiljke", _PosiljkaService.getSvePosiljkeOkruga(Integer.parseInt(okrugid)));
        else if (status != null) model.addAttribute("posiljke", _PosiljkaService.getSveNeIsporucenePosiljke(Integer.parseInt(status)));
        else{
            model.addAttribute("posiljke", _PosiljkaService.getSvePosiljkeFilijale(1));
        }
        return "radnikPanel";
    }

    @GetMapping("/posiljka/{idposiljke}")
    public String getPosiljkaById(@PathVariable int idposiljke, Model model) {
        Posiljka posiljka = _PosiljkaService.getPosiljkaByID(idposiljke);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("posiljka", posiljka);
        return "posiljka";
    }

    @PostMapping("/dodajposiljku")
    public String addNewPosiljka(@ModelAttribute("posiljka") Posiljka posiljka, RedirectAttributes message) {
        _PosiljkaService.dodajNovuPosiljku(posiljka);
        message.addFlashAttribute("message", "Pošiljka uspješno dodana.");
        return "redirect:/radnikpanel";
    }

    @PostMapping("/editposiljka")
    public String editPosiljka(@ModelAttribute("posiljkaforedit") Posiljka posiljka, RedirectAttributes message) {
        _PosiljkaService.editPosiljka(posiljka);
        message.addFlashAttribute("message", "Pošiljka uspješno uređena.");
        return "redirect:/radnikPanel";
    }

}
