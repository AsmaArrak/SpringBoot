package com.poly.gestionproduitg4.controlleur;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/errorPage")
    public String errorPage() {
        return "errorpage";
    }
}
