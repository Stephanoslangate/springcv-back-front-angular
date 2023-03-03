package sn.groupeisi.m2gl.javaspbootcv.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppEmployer implements Serializable {
    private int id;
    int age;
    private String password;
    @NotNull(message = "le nom ne doit pas etre null")
    private String nom;
    @NotNull(message = "le prenom ne doit pas etre null")
    private String prenom;
    @NotNull(message = "le telephone ne doit pas etre null")
    private String telephone;
    @NotNull(message = "le specialite ne doit pas etre null")
    private String specialite;
    @NotNull(message = "le email ne doit pas etre null")
    private String email;
    @NotNull(message = "le adresse ne doit pas etre null")
    private String adresse;
    @NotNull(message = "le experienceProfessionnelle ne doit pas etre null")
    private String exppro;
    @NotNull(message = "le niveauEetude ne doit pas etre null")
    private String niveauEetude;
}
