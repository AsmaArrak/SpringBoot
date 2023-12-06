package com.poly.gestionproduitg4.controlleur; // Correction : "controller" au lieu de "controlleur"


import com.poly.gestionproduitg4.entities.Produit;
import com.poly.gestionproduitg4.service.IServiceCategory;
import com.poly.gestionproduitg4.service.IServiceProduit;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class ProduitController { // Correction : "Controller" au lieu de "Controlleur"

    private final IServiceProduit serviceProduit;
    private final IServiceCategory serviceCategory;

    @GetMapping(path = {"/user/index"})
    public String getAllProducts(Model m, @RequestParam(name = "mc", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "1") int page,
                                 @RequestParam(name = "size", defaultValue = "5") int size) {

        Page<Produit> list = serviceProduit.getProductsByMC( mc, PageRequest.of(page - 1, size));
        m.addAttribute("data", list.getContent());
        m.addAttribute("pages", new int[list.getTotalPages()]);
        m.addAttribute("current", list.getNumber());
        m.addAttribute("mc", mc);

        return "vue";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        serviceProduit.deleteProduct(Long.valueOf(id));
        return "redirect:/user/index";
    }

    @PostMapping("/admin/save")
    public String saveProduit(@Valid Produit p, BindingResult bindingResult , Model m ,@RequestParam("f") MultipartFile mf) throws IOException {
        if (bindingResult.hasErrors()){
            m.addAttribute("categories",serviceCategory.getAllCategories());

            return "ajouter";
        }
        serviceProduit.saveProduct(p,mf);
        return "redirect:/user/index";
    }


    @GetMapping("/admin/edit/{id}")
    public String editProduit(@PathVariable Long id, Model m) {
        m.addAttribute("produit", serviceProduit.getProduct(id));
        m.addAttribute("categories", serviceCategory.getAllCategories());
        return "editer";
    }

    @GetMapping("/admin/formProduit")
    public String formAjout(Model m) {
        m.addAttribute("categories", serviceCategory.getAllCategories());
        m.addAttribute("produit", new Produit());
        return "ajouter";
    }

    @PostMapping("/admin/update/{id}")
    public String updateProduit(@PathVariable Long id, @ModelAttribute Produit p, Model m ,@RequestParam("f") MultipartFile mf) throws IOException {
        p.setId(id);
        serviceProduit.saveProduct(p,mf);
        return "redirect:/user/index";
    }

    @GetMapping("/")
    public String Home(){
        return "redirect:/user/index";
    }

}
