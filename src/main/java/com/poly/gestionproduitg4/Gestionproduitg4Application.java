package com.poly.gestionproduitg4;

import com.poly.gestionproduitg4.Security.service.IAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Gestionproduitg4Application  implements CommandLineRunner {
   /* @Autowired
private ProduitRepository produitRepository;
    @Autowired
private CategoryRepository categoryRepository;*/

    public static void main(String[] args) {
        SpringApplication.run(Gestionproduitg4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //categoryRepository.save(new Categorie(null,"informatique",null));
        //categoryRepository.save(Categorie.builder().nom("electronique").build());
    }

    @Bean
    PasswordEncoder passwordEncoder()
    { return new BCryptPasswordEncoder();}

    //@Bean   // this is a comment cuz we already used it to create the tables
    CommandLineRunner commandLineRunner(IAccountService accountService){
        return args -> {
            accountService.addRole("ADMIN");
            accountService.addRole("USER");
            accountService.addUser("user","123","user@gmail.com");
            accountService.addUser("admin","123","admin@gmail.com");
            accountService.addRoleToUser("user","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");


        };
    }
}
