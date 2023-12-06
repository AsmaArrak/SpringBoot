package com.poly.gestionproduitg4.service;


import com.poly.gestionproduitg4.entities.Categorie;


import java.util.List;
public interface IServiceCategory {
    public void saveCategory(Categorie c);
    public List<Categorie> getAllCategories();
    public void deleteCategory(Long id);
}
