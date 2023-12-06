package com.poly.gestionproduitg4.service;

import com.poly.gestionproduitg4.dao.ProduitRepository;
import com.poly.gestionproduitg4.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@AllArgsConstructor
@Service
public class ProduitImpl implements IServiceProduit {
    private final ProduitRepository produitRepository;

    @Override
    public void saveProduct(Produit p,MultipartFile mf) throws IOException {
        if (!mf.isEmpty())
            p.setPhoto(saveImage(mf));
        produitRepository.save(p);
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @Override
    public Page<Produit> getProductsByMC(String mc, Pageable p) {
        return produitRepository.findByNomContains(mc, p);
    }

    @Override
    public List<Produit> getProductsByCat(Long idCat) { // Correction : "getProductsByCat" au lieu de "getProductsBCat"
        return produitRepository.getProductsByCat(idCat);
    }

    @Override
    public void deleteProduct(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduct(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    private String saveImage(MultipartFile mf)  throws IOException {
        String chemin=null;
        String nom=mf.getOriginalFilename();
        String tab[]=nom.split("\\.");
        String newName=tab[0]+System.currentTimeMillis()+"."+tab[1];
        File f=new ClassPathResource("static/photos").getFile();

        chemin=f.getAbsolutePath();
        Path p= Paths.get(chemin,newName);

        Files.write(p,mf.getBytes());

        return newName;
    }
}
