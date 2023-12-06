package com.poly.gestionproduitg4.service;

import com.poly.gestionproduitg4.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IServiceProduit {

    public void saveProduct(Produit p, MultipartFile mf) throws IOException;
    public List<Produit> getAllProducts();
    public Page<Produit> getProductsByMC(String mc, Pageable p);


    List<Produit> getProductsByCat(Long idCat);

    public void deleteProduct(Long id);
    public Produit getProduct(Long id);


}
