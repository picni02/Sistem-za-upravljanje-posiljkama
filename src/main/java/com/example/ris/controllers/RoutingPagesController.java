package com.example.ris.controllers;

import com.example.ris.models.entities.*;
import com.example.ris.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RoutingPagesController {

    @Autowired
    private VoziloService _VoziloService;
    @Autowired
    private PosiljkaService _PosiljkaService;
    @Autowired
    private LokacijaService _LokacijaService;
    @Autowired
    private OkrugService _OkrugService;
    @Autowired
    private UserService _UserService;
    @Autowired
    private RadnikService _RadnikService;
    @Autowired
    private RegijaService _RegijaService;
    @Autowired
    private StatusService _StatusService;
    @Autowired
    private TipService _TipService;

    @GetMapping("/")
    public String prikazPocetneStranice(Model model) {
        return "index";
    }

    @PostMapping("/")
    public String pretragaPosiljke(@RequestParam("idposiljke") String idPosiljke, Model model){
        Posiljka posiljka = _PosiljkaService.getPosiljkaByID(Integer.parseInt(idPosiljke));
        model.addAttribute("posiljka", posiljka);
        return "posiljka";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registracija")
    public String registrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/dodajokrug")
    public String addOkrug(Model model) {
        Okrug okrug = new Okrug();
        model.addAttribute("okrug", okrug);
        return "dodajokrug";
    }

    @GetMapping("/dodajvozilo")
    public String addVozilo(Model model) {
        Vozilo vozilo = new Vozilo();
        model.addAttribute("vozilo", vozilo);
        return "dodajvozilo";
    }


    @GetMapping("/adminpanel")
    public String adminPanelPage(Model model) {
        model.addAttribute("vozilo", new Vozilo());
        model.addAttribute("lokacija", new Lokacija());
        model.addAttribute("okrug", new Okrug());
        model.addAttribute("okruzi", _OkrugService.getSviOkruzi());
        model.addAttribute("vozila", _VoziloService.getSvaVozila());
        model.addAttribute("lokacije", _LokacijaService.getSveLokacije());
        model.addAttribute("filijale", _RegijaService.getSveFilijaleRegije(1));
        Radnik temp = _RadnikService.getRadnikByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        model.addAttribute("posiljke", _PosiljkaService.getSvePosiljkeFilijale(1));
        return "adminPanel";
    }

    @GetMapping("/radnikpanel")
    public String radnikPanelPage(Model model){
        Radnik radnik = _RadnikService.getRadnikByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        model.addAttribute("vozilo", _VoziloService.getVoziloByEmailRadnika(SecurityContextHolder.getContext().getAuthentication().getName().toString()));
        model.addAttribute("posiljke", _PosiljkaService.getSvePosiljkeOkruga(1));
        model.addAttribute("posiljka", new Posiljka());
        model.addAttribute("statusi", _StatusService.getStatusi());
        model.addAttribute("tipovi", _TipService.getTipovi());
        return "radnikPanel";
    }

    @GetMapping("/superadminpanel")
    public String superadminPanelPage(Model model){
        Radnik radnik = _RadnikService.getRadnikByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        model.addAttribute("regije", _RegijaService.getSveRegije());
        model.addAttribute("filijale", _RegijaService.getSveFilijaleRegije(1));
        model.addAttribute("posiljke", _PosiljkaService.getSvePosiljkeFilijale(1));
        return "superPanel";
    }

    @GetMapping("/profile")
    public String profilePage(Model model) {
        User temp = _UserService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        model.addAttribute("user", temp);
        return "profile";
    }

    @GetMapping("/radnikprofile")
    public String profileRadnikPage(Model model) {
        Radnik temp = _RadnikService.getRadnikByEmail(SecurityContextHolder.getContext().getAuthentication().getName().toString());
        model.addAttribute("radnik", temp);
        return "radnikprofile";
    }
}
