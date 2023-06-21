package com.partie2.gestionPersonne.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="personne")
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    
}
 
