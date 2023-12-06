package com.poly.gestionproduitg4.service;

import com.poly.gestionproduitg4.dao.CategoryRepository;
import com.poly.gestionproduitg4.entities.Categorie;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryImpl implements IServiceCategory {
    private  CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Categorie c) {
         categoryRepository.save(c);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
