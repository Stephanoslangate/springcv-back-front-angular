package sn.groupeisi.m2gl.javaspbootcv.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true ,nullable = false ,  length = 150)
    private String email;
    @Column(unique = false ,nullable = false ,  length = 150)
    private String password;
    @Column(unique = false ,nullable = false ,  length = 50)
    private String telephone;
    @Column(unique = false ,nullable = false ,  length = 150)
    private String prenom;
    @Column(unique = false ,nullable = false ,  length = 150)
    private String nom;
    @Column(unique = false ,nullable = false ,  length = 150)
    private String specialite;
    @Column(unique = false ,nullable = false ,  length = 150)
    private String adresse;
    @Column(unique = false ,nullable = false ,  length = 150)
    private String exppro;
    @Column(unique = false ,nullable = false ,  length = 150)
    private String niveauEetude;
    @Column
    private String age;
}
