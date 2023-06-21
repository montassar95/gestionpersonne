package com.partie2.gestionPersonne.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.partie2.gestionPersonne.model.Personne;
 
@Repository
public interface  PersonneRepository extends JpaRepository<Personne, Long> {
  
	
	@Query("SELECT p  FROM Personne p ORDER BY p.nom ASC, p.prenom ASC")
    List<Personne> findAllByOrderByNomPrenomAsc();
}
