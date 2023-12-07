package com.poly.gestionproduitg4.Security.service;

import com.poly.gestionproduitg4.Security.entities.AppRole;
import com.poly.gestionproduitg4.Security.entities.AppUser;
import com.poly.gestionproduitg4.Security.repository.RoleRepository;
import com.poly.gestionproduitg4.Security.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AccountService implements IAccountService{
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void addRole(String role) {
        roleRepository.save(new AppRole(role));
        //roleRepository.save(appRole.builder().role(role).build()); // you can use this (design pattern)

    }

    @Override
    public void addUser(String userName, String password, String mail) {
        AppUser user=getUserByUSerName(userName);
        if(user!=null)
            throw new RuntimeException("user exists");
        userRepository.save(AppUser.builder()
                        .id(UUID.randomUUID().toString())
                .mail(mail)
                .userName(userName)
                .password(passwordEncoder.encode(password))
                .build());

    }

    @Override
    public void addRoleToUser(String user, String role) {
        AppUser u=getUserByUSerName(user);
        AppRole rol=roleRepository.findById(role).orElse(null);
        u.getRoles().add(rol);

    }

    @Override
    public AppUser getUserByUSerName(String userName) {
        return userRepository.findAppUserByUserName(userName);
    }
}
