package com.poly.gestionproduitg4.Security.repository;

import com.poly.gestionproduitg4.Security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,String> {

    public AppUser findAppUserByUserName(String userName);
}
