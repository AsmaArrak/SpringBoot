package com.poly.gestionproduitg4;

import com.poly.gestionproduitg4.dao.CategoryRepository;
import com.poly.gestionproduitg4.dao.ProduitRepository;
import com.poly.gestionproduitg4.entities.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Gestionproduitg4Application  implements CommandLineRunner {
   /* @Autowired
private ProduitRepository produitRepository;
    @Autowired
private CategoryRepository categoryRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(Gestionproduitg4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //categoryRepository.save(new Categorie(null,"informatique",null));
        //categoryRepository.save(Categorie.builder().nom("electronique").build());
    }
}
