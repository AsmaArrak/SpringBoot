package com.poly.gestionproduitg4.Security.service;

import com.poly.gestionproduitg4.Security.entities.AppUser;

public interface IAccountService {
    public void addRole(String role);
    public void addUser(String userName,String password,String mail);
    public void addRoleToUser(String user, String role);
    public AppUser getUserByUSerName(String userName);
}
