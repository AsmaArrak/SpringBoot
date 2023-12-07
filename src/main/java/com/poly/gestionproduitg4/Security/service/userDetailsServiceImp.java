package com.poly.gestionproduitg4.Security.service;

import com.poly.gestionproduitg4.Security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class userDetailsServiceImp implements UserDetailsService {
    private IAccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser=accountService.getUserByUSerName(username);
        List<GrantedAuthority> authorityList=new ArrayList<>();
        appUser.getRoles().forEach(e->authorityList.add(new SimpleGrantedAuthority(e.getRole())));
        return new User(appUser.getUserName(),appUser.getPassword(),authorityList);
    }
}
