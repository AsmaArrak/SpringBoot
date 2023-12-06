package com.poly.gestionproduitg4.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1,max=20)
    private String nom;
    @Min(1)
    private double prix;
    @Min(0)
    private int quantite;
    @ManyToOne
    @NotNull(message="la categorie ne doit pas etre null")
    private Categorie categorie;
    private String photo;


}
