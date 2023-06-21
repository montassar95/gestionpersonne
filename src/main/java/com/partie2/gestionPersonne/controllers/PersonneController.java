package com.partie2.gestionPersonne.controllers;

import static com.partie2.gestionPersonne.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.partie2.gestionPersonne.dto.PersonneDto;
import com.partie2.gestionPersonne.services.PersonneService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 

@RestController
  @Api(tags =APP_ROOT+"/personnes")
public class PersonneController {

	private PersonneService personneService;

	@Autowired
	public PersonneController(PersonneService personneService) {

		this.personneService = personneService;
	}

	
	@PostMapping(path = APP_ROOT+"/personnes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Enregistrer un personne",notes = "Cette methode permet d'enregistrer ou modifier un personne", response = PersonneDto.class)
	 
	public ResponseEntity<PersonneDto>  save(@RequestBody PersonneDto personneDto) {

		return ResponseEntity.ok(personneService.save(personneDto));

	}
	
	
	

	@GetMapping(path = APP_ROOT+"/personnes/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Recherche un personne par ID",notes = "Cette methode permet de chercher un personne par son ID", response = PersonneDto.class)
	 
	public ResponseEntity<PersonneDto>  findById(@PathVariable("id") Long id) {

		return ResponseEntity.ok(personneService.findById(id));

	}
	
 

	@GetMapping(path = APP_ROOT+"/personnes/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Renvoi la liste des personne",notes = "Cette methode permet de chercher la list des personnes dans la BDD"
	                                                   ,responseContainer = "List<personneDto.class>")
	 
	public ResponseEntity< List<PersonneDto> >findAll() {

		return   ResponseEntity.ok(personneService.findAll());

	}
	
	
	
	
	
	@DeleteMapping(path = APP_ROOT+"/personnes/delete/{id}")
	@ApiOperation(value = "Supprimier un personne",notes = "Cette methode permet de supprimier un personne par son id dans la BDD" )
 
	public ResponseEntity findByUsername(@PathVariable("id") Long id) {

		personneService.delete(id);
		
		return ResponseEntity.ok().build();

	}

}
