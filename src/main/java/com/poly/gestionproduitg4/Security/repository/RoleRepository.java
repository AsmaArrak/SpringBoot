package com.poly.gestionproduitg4.Security.repository;

import com.poly.gestionproduitg4.Security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<AppRole,String> {
}
