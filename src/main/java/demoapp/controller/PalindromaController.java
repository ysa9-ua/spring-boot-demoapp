package demoapp.controller;

import demoapp.service.PalindromaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PalindromaController {

    @Autowired
    private PalindromaService service;

    @GetMapping("/palindroma")
    public String formulario(PalindromaData palindromaData) {
        return "formPalindroma";
    }

    @PostMapping("/palindroma")
    public String comprobar(@ModelAttribute @Valid PalindromaData palindromaData,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "formPalindroma";
        }
        model.addAttribute("palabra", palindromaData.getPalabra());
        model.addAttribute("esPalindroma", service.esPalindroma(palindromaData.getPalabra()));
        return "resultado";
    }
}