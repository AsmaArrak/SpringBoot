package com.poly.gestionproduitg4.dao;

import com.poly.gestionproduitg4.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categorie,Long> {
}
